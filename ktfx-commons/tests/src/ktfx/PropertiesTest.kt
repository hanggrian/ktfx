package ktfx

import ktfx.beans.property.asProperty
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PropertiesTest {

    private val textProperty = "".asProperty()
    private val intProperty1 = 0.asProperty()
    private val intProperty2 = 10.asProperty()

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