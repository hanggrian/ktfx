package ktfx.text

import javafx.util.Duration
import javafx.util.converter.DefaultStringConverter
import javafx.util.converter.IntegerStringConverter
import ktfx.time.ms
import ktfx.time.toDuration
import kotlin.test.Test
import kotlin.test.assertEquals

class StringConverterTest {
    private val defaultConverter = DefaultStringConverter()
    private val intConverter = IntegerStringConverter()

    @Test fun buildStringConverter() {
        val converter = buildStringConverter<Duration> {
            toString { it!!.toString() }
            fromString { it.toDuration() }
        }
        assertEquals(converter.toString(1.ms), "1.0 ms")
        assertEquals(converter.fromString("1.0ms"), 1.ms)

        val primitiveConverter = buildStringConverter<Int> {
            fromString { it.toInt() }
        }
        assertEquals(primitiveConverter.toString(123), "123")
        assertEquals(primitiveConverter.fromString("123"), 123)
    }

    @Test fun invoke() {
        assertEquals(intConverter.toString(123), intConverter(123))
        assertEquals(defaultConverter.toString(null), defaultConverter(null))
    }

    @Test fun get() {
        assertEquals(intConverter.fromString("123"), intConverter["123"])
        assertEquals(defaultConverter.fromString("Hello world"), defaultConverter["Hello world"])
    }
}
