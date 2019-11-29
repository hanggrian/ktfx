package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValueDelegationTest {
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

    private val emptyString = stringPropertyOf()

    @Test fun any() {
        assertEquals(personValue, person1)
        personValue = person2
        assertEquals(person.value, person2)
    }

    @Test fun boolean() {
        assertFalse(booleanValue)
        booleanValue = true
        assertTrue(boolean.value)
    }

    @Test fun integer() {
        assertEquals(integerValue, 1)
        integerValue = 2
        assertEquals(integer.value, 2)
    }

    @Test fun string() {
        assertEquals(stringValue, "Hello")
        stringValue = "World"
        assertEquals(string.value, "World")

        assertFalse(string.toBooleanBinding { it.isNullOrBlank() }.value)
        assertTrue(emptyString.toBooleanBinding { it.isNullOrBlank() }.value)

        assertFalse(string.toBooleanBinding { it.isNullOrEmpty() }.value)
        assertTrue(emptyString.toBooleanBinding { it.isNullOrEmpty() }.value)

        assertEquals("World", string.toStringBinding { it.orEmpty() }.value)
        assertEquals("", emptyString.toStringBinding { it.orEmpty() }.value)

        assertEquals(IntRange(0, 4), string.toBinding { it!!.indices }.value)

        assertEquals(4, string.toIntBinding { it!!.lastIndex }.value)
    }

    data class Person(
        val name: String,
        val age: Int
    )
}