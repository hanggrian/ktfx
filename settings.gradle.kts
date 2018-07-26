ARTIFACTS.forEach {
    include(":$it")
}

include(":$ARTIFACT_LAYOUTS:thirdparty:$ARTIFACT_LAYOUTS_CONTROLSFX")
include(":$ARTIFACT_LAYOUTS:thirdparty:$ARTIFACT_LAYOUTS_JFOENIX")

include(":testing")
include(":demo")