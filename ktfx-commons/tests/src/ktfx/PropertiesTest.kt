package ktfx

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PropertiesTest {

    private val textProperty = stringPropertyOf("")
    private val intProperty1 = intPropertyOf(0)
    private val intProperty2 = intPropertyOf(10)

    @Test fun bind() {
        textProperty.bind(intProperty1.asString())
        textProperty.bind(intProperty2.asString())

        assertTrue(textProperty.isBound)
        assertFalse(intProperty1.isBound)
        assertEquals(textProperty.get(), "10")

        intProperty2.set(5)
        assertEquals(textProperty.get(), "5")
    }
}