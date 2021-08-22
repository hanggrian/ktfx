const val RELEASE_GROUP = "com.hendraanggrian.ktfx"
const val RELEASE_ARTIFACT = "ktfx"
const val RELEASE_VERSION = "0.1-SNAPSHOT"
const val RELEASE_DESCRIPTION = "Kotlin extensions for JavaFX app development"
const val RELEASE_GITHUB = "https://github.com/hendraanggrian/$RELEASE_ARTIFACT"

fun getGithubRemoteUrl(artifact: String = RELEASE_ARTIFACT) =
    `java.net`.URL("$RELEASE_GITHUB/tree/main/$artifact/src")