package ktfx.util

import javafx.util.converter.IntegerStringConverter
import ktfx.get
import ktfx.invoke
import org.junit.Test
import kotlin.test.assertEquals

class StringConverterTest {

    private val converter = IntegerStringConverter()

    @Test fun invoke() = assertEquals(converter.toString(123), converter(123))

    @Test fun get() = assertEquals(converter.fromString("123"), converter["123"])
}