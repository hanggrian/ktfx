KTFX_ARTIFACTS.forEach {
    include(":$it")
}

KTFX_THIRDPARTY_ARTIFACTS.forEach {
    include(":${it.substringBeforeLast('-')}:thirdparty:${it.substringAfterLast('-')}")
}

include(":testing")
include(":example")