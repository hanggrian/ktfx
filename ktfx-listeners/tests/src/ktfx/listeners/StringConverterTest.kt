package ktfx.listeners

import org.junit.Test
import kotlin.test.assertEquals

class StringConverterTest {

    @Test fun primitive() {
        val converter = buildStringConverter<Int> {
            fromString { it.toInt() }
        }
        assertEquals(converter.toString(123), "123")
        assertEquals(converter.fromString("123"), 123)
    }

    @Test fun custom() {
        val converter = buildStringConverter<Person> {
            toString { it!!.name }
            fromString { Person(it) }
        }
        assertEquals(converter.toString(Person("Hendra")), "Hendra")
        assertEquals(converter.fromString("Hendra"), Person("Hendra"))
    }
}