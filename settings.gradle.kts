ARTIFACTS.forEach {
    include(":$it")
}

ARTIFACTS_THIRDPARTY.forEach {
    include(":$it")
}

include(":wiki")

include(":testing")

include(":demo")