plugins {
    `git-publish`
}

gitPublish {
    repoUri = "$RELEASE_WEB.wiki"
    branch = "master"
    contents.from("src")
}