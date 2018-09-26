const val ARTIFACT_COMMONS = "$RELEASE_ARTIFACT-commons"
const val ARTIFACT_COROUTINES = "$RELEASE_ARTIFACT-coroutines"
const val ARTIFACT_LAYOUTS = "$RELEASE_ARTIFACT-layouts"
const val ARTIFACT_LISTENERS = "$RELEASE_ARTIFACT-listeners"
const val ARTIFACT_STYLES = "$RELEASE_ARTIFACT-styles"

val ARTIFACTS = listOf(
    RELEASE_ARTIFACT, ARTIFACT_COMMONS, ARTIFACT_COROUTINES, ARTIFACT_LAYOUTS, ARTIFACT_LISTENERS, ARTIFACT_STYLES
)

const val ARTIFACT_THIRDPARTY_CONTROLSFX = "ktfx-controlsfx"
const val ARTIFACT_THIRDPARTY_JFOENIX = "ktfx-jfoenix"

val ARTIFACTS_THIRDPARTY = listOf(
    "thirdparty:$ARTIFACT_THIRDPARTY_CONTROLSFX",
    "thirdparty:$ARTIFACT_THIRDPARTY_JFOENIX"
)

const val RULESET = "dev:ruleset"
const val RULESET_BASE = "dev:ruleset-base"
const val RULESET_EXTENDED = "dev:ruleset-extended"
const val TESTING = "dev:testing"
const val TESTING_RULESET = "dev:testing-ruleset"