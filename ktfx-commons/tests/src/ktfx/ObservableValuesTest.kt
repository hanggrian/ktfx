package ktfx

import javafx.beans.property.SimpleStringProperty
import ktfx.bindings.indices
import ktfx.bindings.isNullOrBlank
import ktfx.bindings.isNullOrEmpty
import ktfx.bindings.lastIndex
import ktfx.bindings.orEmpty
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValuesTest {

    private val person1 = Person("Hendra", 24)
    private val person2 = Person("Hobo", 50)
    private val person = propertyOf(person1)
    private var personValue: Person? by person

    private val boolean = booleanPropertyOf(false)
    private var booleanValue: Boolean by boolean

    private var integer = intPropertyOf(1)
    private var integerValue: Int by integer

    private val string = stringPropertyOf("Hello")
    private var stringValue: String? by string

    private val emptyString = SimpleStringProperty()

    @Test
    fun any() {
        assertEquals(personValue, person1)
        personValue = person2
        assertEquals(person.value, person2)
    }

    @Test
    fun boolean() {
        assertFalse(booleanValue)
        booleanValue = true
        assertTrue(boolean.value)
    }

    @Test
    fun integer() {
        assertEquals(integerValue, 1)
        integerValue = 2
        assertEquals(integer.value, 2)
    }

    @Test
    fun string() {
        assertEquals(stringValue, "Hello")
        stringValue = "World"
        assertEquals(string.value, "World")

        assertFalse(string.isNullOrBlank().get())
        assertTrue(emptyString.isNullOrBlank().get())

        assertFalse(string.isNullOrEmpty().get())
        assertTrue(emptyString.isNullOrEmpty().get())

        assertEquals("World", string.orEmpty().get())
        assertEquals("", emptyString.orEmpty().get())

        assertEquals(IntRange(0, 4), string.indices.get())

        assertEquals(4, string.lastIndex.get())
    }

    data class Person(
        val name: String,
        val age: Int
    )
}