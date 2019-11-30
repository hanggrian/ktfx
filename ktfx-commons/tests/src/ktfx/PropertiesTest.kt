package ktfx

import ktfx.util.seconds
import kotlin.test.Test

class PropertiesTest {

    @Test fun property() {
        val duration = propertyOf(1.seconds)
        duration.value = 2.seconds
        // val finalDuration = finalPropertyOf(1.seconds)
        // assertFails { finalDuration.value = 2.seconds }
    }
}