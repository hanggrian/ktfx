const val ARTIFACT_CORE = "core-ktx"
const val ARTIFACT_COROUTINES = "coroutines-ktx"
const val ARTIFACT_LAYOUTS = "layouts-ktx"
const val ARTIFACT_LISTENERS = "listeners-ktx"
const val ARTIFACT_STYLES = "styles-ktx"

val ARTIFACTS = listOf(
    RELEASE_ARTIFACT, ARTIFACT_CORE, ARTIFACT_COROUTINES, ARTIFACT_LAYOUTS, ARTIFACT_LISTENERS, ARTIFACT_STYLES
)

const val ARTIFACT_LAYOUTS_CONTROLSFX = "layouts-controlsfx-ktx"
const val ARTIFACT_LAYOUTS_JFOENIX = "layouts-jfoenix-ktx"

val ARTIFACTS_THIRDPARTY = listOf(
    "$ARTIFACT_LAYOUTS:thirdparty:$ARTIFACT_LAYOUTS_CONTROLSFX",
    "$ARTIFACT_LAYOUTS:thirdparty:$ARTIFACT_LAYOUTS_JFOENIX"
)