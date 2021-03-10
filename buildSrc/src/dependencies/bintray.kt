private const val VERSION_BINTRAY_RELEASE = "0.9.2"

fun Dependencies.bintrayRelease() = "com.novoda:bintray-release:$VERSION_BINTRAY_RELEASE"

val Plugins.`bintray-release` get() = id("com.novoda.bintray-release")