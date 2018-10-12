const val ARTIFACT_COMMONS = "$RELEASE_ARTIFACT-commons"
const val ARTIFACT_CORE = "$RELEASE_ARTIFACT-core"
const val ARTIFACT_COROUTINES = "$RELEASE_ARTIFACT-coroutines"
const val ARTIFACT_LAYOUTS = "$RELEASE_ARTIFACT-layouts"
const val ARTIFACT_LISTENERS = "$RELEASE_ARTIFACT-listeners"
const val ARTIFACT_STYLES = "$RELEASE_ARTIFACT-styles"

/** Main artifacts. */
val ARTIFACTS = listOf(
    RELEASE_ARTIFACT,
    ARTIFACT_COMMONS,
    ARTIFACT_CORE,
    ARTIFACT_COROUTINES,
    ARTIFACT_LAYOUTS,
    ARTIFACT_LISTENERS,
    ARTIFACT_STYLES
)

const val ARTIFACT_THIRDPARTY_CONTROLSFX = "thirdparty:ktfx-controlsfx"
const val ARTIFACT_THIRDPARTY_JFOENIX = "thirdparty:ktfx-jfoenix"

/** Third-party artifacts. */
val ARTIFACTS_THIRDPARTY = listOf(
    ARTIFACT_THIRDPARTY_CONTROLSFX,
    ARTIFACT_THIRDPARTY_JFOENIX
)

const val ARTIFACT_DEV_RULESET_CORE = "dev:ruleset-core"
const val ARTIFACT_DEV_RULESET_ALL = "dev:ruleset-all"
const val ARTIFACT_DEV_RULESET_NO_INSTANCE = "dev:ruleset-no-instance"
const val ARTIFACT_DEV_RULESET_SINGLE_PACKAGE = "dev:ruleset-single-package"
const val ARTIFACT_DEV_TESTING = "dev:testing"
const val ARTIFACT_DEV_TESTING_RULESET = "dev:testing-ruleset"

/** Internal modules. */
val ARTIFACTS_DEV = listOf(
    ARTIFACT_DEV_RULESET_CORE,
    ARTIFACT_DEV_RULESET_ALL,
    ARTIFACT_DEV_RULESET_NO_INSTANCE,
    ARTIFACT_DEV_RULESET_SINGLE_PACKAGE,
    ARTIFACT_DEV_TESTING,
    ARTIFACT_DEV_TESTING_RULESET
)

operator fun String.invoke(): String = when {
    ':' !in this -> this
    else -> substringAfter(':')
}