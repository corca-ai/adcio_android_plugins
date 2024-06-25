package ai.corca.dacs

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.runBlocking
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.diff.DiffFormatter
import org.eclipse.jgit.lib.ObjectId
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevWalk
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.treewalk.CanonicalTreeParser
import java.io.ByteArrayOutputStream
import java.io.File
import kotlin.io.path.createTempDirectory

class DacsProvider {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getRemoteLatestCommitIds(repoUrl: String, branch: String = "main"): Pair<String, String> {
        println("Creating temporary directory23523rt23r23r23r23r23r32r2r332r3r2r23r3r")
        val tempDir = createTempDirectory("TempGitRepo").toFile()

        val repo = Git.cloneRepository()
            .setURI(repoUrl)
            .setBranch(branch)
            .setDirectory(tempDir)
            .call()

        val latestCommit = repo.repository.resolve("refs/remotes/origin/$branch")
        val previousCommit = repo.repository.resolve("refs/remotes/origin/$branch^")

        repo.close()

        return Pair(previousCommit.name, latestCommit.name)
    }

    private fun getDiffBetweenCommits(repoPath: String, oldCommitId: String, newCommitId: String): String {
        val repository = FileRepositoryBuilder()
            .setGitDir(File("$repoPath/.git"))
            .readEnvironment()
            .findGitDir()
            .build()

        val oldTreeParser = getTreeParser(repository, oldCommitId)
        val newTreeParser = getTreeParser(repository, newCommitId)

        val output = ByteArrayOutputStream()
        val diffFormatter = DiffFormatter(output)
        diffFormatter.setRepository(repository)
        diffFormatter.format(oldTreeParser, newTreeParser)

        val result = StringBuilder()
        val diffLines = output.toString().lines()
        var isRelevantDiff = false  // 관련 파일인지 확인하는 플래그

        for (line in diffLines) {
            if (line.startsWith("diff --git")) {
                val filePath = line.split(" ").last()
                isRelevantDiff = isRelevantFile(filePath)  // 파일 경로를 검사하여 관련 파일 여부를 결정
                if (isRelevantDiff) {
                    result.append("diff for: ").append(filePath).append("\n")
                }
            }
            if (isRelevantDiff) {
                result.append(line).append("\n")  // 관련 파일의 diff 전체를 추가
            }
        }

        return result.toString()
    }

    private fun isRelevantFile(filePath: String): Boolean {
        return filePath.contains("/adcio_analytics/src/main/java/ai/corca/adcio_analytics/feature/AdcioAnalytics.kt") ||
                filePath.contains("/adcio_placement/src/main/java/ai/corca/adcio_placement/feature/AdcioPlacement.kt")
    }

    private fun getTreeParser(repository: Repository, objectId: String): CanonicalTreeParser {
        val revWalk = RevWalk(repository)
        val commit = revWalk.parseCommit(ObjectId.fromString(objectId))
        val tree = commit.tree

        val treeParser = CanonicalTreeParser()
        val reader = repository.newObjectReader()
        treeParser.reset(reader, tree.id)

        revWalk.dispose()

        return treeParser
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun greet() {
        val repoUrl = "https://github.com/corca-ai/adcio_android_plugins.git"
        val branch = "dacs_test"

        val (oldCommitId, newCommitId) = getRemoteLatestCommitIds(repoUrl, branch)

        val tempRepoPath = createTempDirectory("TempGitRepo").toAbsolutePath().toString()
        val repo = Git.cloneRepository()
            .setURI(repoUrl)
            .setBranch(branch)
            .setDirectory(File(tempRepoPath))
            .call()

        val diff = getDiffBetweenCommits(tempRepoPath, oldCommitId, newCommitId)
        val createDacs = CreateDacs()

        println(diff)

        runBlocking {
            val newDocs = createDacs.updateDocumentation(diff)
            println(newDocs)
            updateReadmeWithDiff(tempRepoPath, newDocs)
        }

        repo.close()
    }

    private fun updateReadmeWithDiff(repoPath: String, newDocs: String) {
        val readmePath = "/Users/yuhyeonmyeong/github/adcio_android_plugins/dacs/README.md"
        val readmeFile = File(readmePath)

        readmeFile.writeText(newDocs)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val dacsProvider = DacsProvider()
    dacsProvider.greet()
}