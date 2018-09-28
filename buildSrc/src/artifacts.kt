const val ARTIFACT_COMMONS = "$RELEASE_ARTIFACT-commons"
const val ARTIFACT_COROUTINES = "$RELEASE_ARTIFACT-coroutines"
const val ARTIFACT_LAYOUTS = "$RELEASE_ARTIFACT-layouts"
const val ARTIFACT_LISTENERS = "$RELEASE_ARTIFACT-listeners"
const val ARTIFACT_STYLES = "$RELEASE_ARTIFACT-styles"

/** Main artifacts. */
val ARTIFACTS = listOf(
    RELEASE_ARTIFACT,
    ARTIFACT_COMMONS,
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

const val ARTIFACT_DEV_RULESET = "dev:ruleset"
const val ARTIFACT_DEV_RULESET_BASE = "dev:ruleset-base"
const val ARTIFACT_DEV_RULESET_EXTENDED = "dev:ruleset-extended"
const val ARTIFACT_DEV_TESTING = "dev:testing"
const val ARTIFACT_DEV_TESTING_RULESET = "dev:testing-ruleset"

/** Internal modules. */
val ARTIFACTS_DEV = listOf(
    ARTIFACT_DEV_RULESET,
    ARTIFACT_DEV_RULESET_BASE,
    ARTIFACT_DEV_RULESET_EXTENDED,
    ARTIFACT_DEV_TESTING,
    ARTIFACT_DEV_TESTING_RULESET
)

operator fun String.invoke(): String = when {
    ':' !in this -> this
    else -> substringAfter(':')
}