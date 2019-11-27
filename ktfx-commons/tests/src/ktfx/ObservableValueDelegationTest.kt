package ktfx

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ObservableValueDelegationTest {
    private val person1 = Person("Hendra", 24)
    private val person2 = Person("Hobo", 50)
    private val person = property(person1)
    private var personValue: Person? by person

    private val boolean = booleanProperty(false)
    private var booleanValue: Boolean by boolean

    private var integer = intProperty(1)
    private var integerValue: Int by integer

    private val string = stringProperty("Hello")
    private var stringValue: String? by string

    private val emptyString = stringProperty()

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

        assertFalse(string.toBoolean { it.isNullOrBlank() }.value)
        assertTrue(emptyString.toBoolean { it.isNullOrBlank() }.value)

        assertFalse(string.toBoolean { it.isNullOrEmpty() }.value)
        assertTrue(emptyString.toBoolean { it.isNullOrEmpty() }.value)

        assertEquals("World", string.toString { it.orEmpty() }.value)
        assertEquals("", emptyString.toString { it.orEmpty() }.value)

        assertEquals(IntRange(0, 4), string.toAny { it!!.indices }.value)

        assertEquals(4, string.toInt { it!!.lastIndex }.value)
    }

    data class Person(
        val name: String,
        val age: Int
    )
}