package ktfx

import javafx.util.converter.DefaultStringConverter
import javafx.util.converter.IntegerStringConverter
import kotlin.test.Test
import kotlin.test.assertEquals

class StringConverterTest {

    private val defaultConverter = DefaultStringConverter()
    private val intConverter = IntegerStringConverter()

    @Test
    fun invoke() {
        assertEquals(intConverter.toString(123), intConverter(123))
        assertEquals(defaultConverter.toString(null), defaultConverter(null))
    }

    @Test
    fun get() {
        assertEquals(intConverter.fromString("123"), intConverter["123"])
        assertEquals(defaultConverter.fromString("Hello world"), defaultConverter["Hello world"])
    }
}