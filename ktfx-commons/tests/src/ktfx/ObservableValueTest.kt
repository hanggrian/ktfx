package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValueTest {
    private val emptyString = stringPropertyOf()

    @Test fun test() {
        assertFalse(emptyString.hasValue())
        emptyString.value = ""
        assertTrue(emptyString.hasValue())
        emptyString.clear()
        assertFalse(emptyString.hasValue())
    }
}