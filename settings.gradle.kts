ARTIFACTS.forEach { include(":$it") }
ARTIFACTS_THIRDPARTY.forEach { include(":$it") }

include(":testing")
include(":demo")