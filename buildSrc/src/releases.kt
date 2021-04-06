const val RELEASE_USER = "hendraanggrian"
const val RELEASE_GROUP = "io.github.$RELEASE_USER.ktfx"
const val RELEASE_ARTIFACT = "ktfx"
const val RELEASE_VERSION = "8.0.0-SNAPSHOT"
const val RELEASE_DESCRIPTION = "Kotlin extensions for JavaFX app development"
const val RELEASE_URL = "https://github.com/$RELEASE_USER/$RELEASE_ARTIFACT"

fun getReleaseSourceUrl(project: String = RELEASE_ARTIFACT) =
    `java.net`.URL("$RELEASE_URL/tree/main/$project/src")