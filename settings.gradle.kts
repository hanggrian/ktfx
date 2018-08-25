ARTIFACTS.forEach { include(":$it") }
ARTIFACTS_CORE_THIRDPARTY.forEach { include(":$it") }
ARTIFACTS_LAYOUTS_THIRDPARTY.forEach { include(":$it") }

include(":testing")
include(":demo")