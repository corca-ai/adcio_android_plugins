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

        println("Cr3r23r32r2r332r3r2r23r3r ${tempDir}")

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
        var currentFile: String? = null

        println("Creating temporary directory")
        for (line in diffLines) {
            if (line.startsWith("diff --git")) {
                currentFile = line.split(" ").last()
                result.append(currentFile).append("\n\n")
            }
            if (currentFile != null && isRelevantObject(currentFile)) {
                if (line.startsWith("+") && !line.startsWith("+++")) {
                    result.append(line).append("\n")
                } else if (line.startsWith("-") && !line.startsWith("---")) {
                    result.append(line).append("\n")
                }
            }
        }

        println("result")

        return result.toString()
    }

    private fun isRelevantObject(filePath: String): Boolean {
        return filePath.contains(
            "/adcio_analytics/src/main/java/ai/corca/adcio_analytics/feature/AdcioAnalytics.kt") ||
                filePath.contains(
                    "/adcio_placement/src/main/java/ai/corca/adcio_placement/feature/AdcioPlacement.kt")
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
        val branch = "main"

        val (oldCommitId, newCommitId) = getRemoteLatestCommitIds(repoUrl, branch)

        val tempRepoPath = createTempDirectory("TempGitRepo").toAbsolutePath().toString()
        val repo = Git.cloneRepository()
            .setURI(repoUrl)
            .setBranch(branch)
            .setDirectory(File(tempRepoPath))
            .call()

        val diff = getDiffBetweenCommits(tempRepoPath, oldCommitId, newCommitId)
        val createDacs = CreateDacs()

        println("diff")
        println(diff)

        runBlocking {
            createDacs.greet(diff)
            updateReadmeWithDiff(tempRepoPath, diff)
        }

        repo.close()
        File(tempRepoPath).deleteRecursively()
    }

    private fun updateReadmeWithDiff(repoPath: String, diff: String) {
        val readmePath = "$repoPath/dacs/README.md"
        val readmeFile = File(readmePath)

        if (!readmeFile.exists()) {
            throw IllegalStateException("README.md not found at $readmePath")
        }

        val updatedContent = StringBuilder()
        readmeFile.forEachLine { line ->
            updatedContent.append(line).append("\n")
            if (line.trim() == "<!-- DIFF_START -->") {
                updatedContent.append("\n").append(diff).append("\n")
            }
        }

        readmeFile.writeText(updatedContent.toString())
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val dacsProvider = DacsProvider()
    dacsProvider.greet()
}