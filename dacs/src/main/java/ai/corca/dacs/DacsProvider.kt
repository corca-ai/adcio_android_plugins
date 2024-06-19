package ai.corca.dacs

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

class DacsProvider {
    fun getRemoteLatestCommitIds(repoUrl: String, branch: String = "main"): Pair<String, String> {
        val tempDir = File.createTempFile("TempGitRepo", "")
        if (!tempDir.delete()) {
            throw RuntimeException("Could not delete temp file ${tempDir.absolutePath}")
        }

        val repo = Git.cloneRepository()
            .setURI(repoUrl)
            .setBranch(branch)
            .setDirectory(tempDir)
            .call()

        val latestCommit = repo.repository.resolve("refs/remotes/origin/$branch")
        val previousCommit = repo.repository.resolve("refs/remotes/origin/$branch^")

        return Pair(previousCommit.name, latestCommit.name)
    }

    fun getDiffBetweenCommits(repoPath: String, oldCommitId: String, newCommitId: String): String {
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
        val entries = diffFormatter.scan(oldTreeParser, newTreeParser)

        val result = StringBuilder()
        for (entry in entries) {
            val fileDiffOutput = ByteArrayOutputStream()
            val fileDiffFormatter = DiffFormatter(fileDiffOutput)
            fileDiffFormatter.setRepository(repository)
            fileDiffFormatter.format(entry)

            val diffLines = fileDiffOutput.toString().lines()
            result.append(entry.newPath).append("\n\n")
            for (line in diffLines) {
                if (line.startsWith("+") && !line.startsWith("+++")) {
                    result.append(line).append("\n")
                } else if (line.startsWith("-") && !line.startsWith("---")) {
                    result.append(line).append("\n")
                }
            }
            result.append("\n")
        }

        return result.toString()
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

    // 메인 함수
    fun greet() {
        val repoUrl = "https://github.com/corca-ai/adcio_android_plugins.git" // 원격 저장소 URL

        val (oldCommitId, newCommitId) = getRemoteLatestCommitIds(repoUrl)
        val tempRepoPath = "/Users/yuhyeonmyeong/github/adcio_android_plugins" // 로컬에 임시 저장소 경로

        val diff = getDiffBetweenCommits(tempRepoPath, oldCommitId, newCommitId)
        val createDacs = CreateDacs()

        runBlocking { createDacs.greet(diff) }

        updateReadmeWithDiff(tempRepoPath, diff)
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

fun main() {
    val dacsProvider = DacsProvider()
    dacsProvider.greet()
}
