package ktfx.util

import javafx.util.Duration
import javafx.util.converter.DefaultStringConverter
import javafx.util.converter.IntegerStringConverter
import kotlin.test.Test
import kotlin.test.assertEquals

class StringConverterTest {
    private val defaultConverter = DefaultStringConverter()
    private val intConverter = IntegerStringConverter()

    @Test fun invoke() {
        assertEquals(intConverter.toString(123), intConverter(123))
        assertEquals(defaultConverter.toString(null), defaultConverter(null))
    }

    @Test fun get() {
        assertEquals(intConverter.fromString("123"), intConverter["123"])
        assertEquals(defaultConverter.fromString("Hello world"), defaultConverter["Hello world"])
    }

    @Test fun buildStringConverterPrimitive() {
        val converter = buildStringConverter<Int> {
            fromString { it.toInt() }
        }
        assertEquals(converter.toString(123), "123")
        assertEquals(converter.fromString("123"), 123)
    }

    @Test fun buildStringConverterCustom() {
        val converter = buildStringConverter<Duration> {
            toString { it!!.toString() }
            fromString { Duration.valueOf(it) }
        }
        assertEquals(converter.toString(1.millis), "1.0 ms")
        assertEquals(converter.fromString("1.0ms"), 1.millis)
    }
}