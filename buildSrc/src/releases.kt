const val RELEASE_USER = "hendraanggrian"
const val RELEASE_ARTIFACT = "ktfx"
const val RELEASE_GROUP = "com.$RELEASE_USER.$RELEASE_ARTIFACT"
const val RELEASE_VERSION = "8.5.4"
const val RELEASE_DESC = "Kotlin extensions for JavaFX app development"
const val RELEASE_WEB = "https://github.com/$RELEASE_USER/$RELEASE_ARTIFACT"

val BINTRAY_USER: String? get() = System.getenv("BINTRAY_USER")
val BINTRAY_KEY: String? get() = System.getenv("BINTRAY_KEY")