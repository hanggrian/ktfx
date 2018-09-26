/** Main artifacts. */
ARTIFACTS.forEach { include(it) }

/** Third-party artifacts. */
ARTIFACTS_THIRDPARTY.forEach { include(it) }

/** Internal modules. */
include(RULESET)
include(RULESET_BASE)
include(RULESET_EXTENDED)
include(TESTING)
include(TESTING_RULESET)

/** Alarmingly simple demo. */
include("demo")