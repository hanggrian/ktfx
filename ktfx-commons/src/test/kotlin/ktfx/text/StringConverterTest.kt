package ktfx.text

import kotlin.test.Ignore

// TODO: find out why enabling this class throws `e: Could not load module <Error module>`
@Ignore
class StringConverterTest {
//    private val defaultConverter = DefaultStringConverter()
//    private val intConverter = IntegerStringConverter()
//
//    @Test
//    fun buildStringConverter() {
//        val converter =
//            buildStringConverter {
//                toString { it!!.toString() }
//                fromString { it.toDuration() }
//            }
//        assertEquals(converter.toString(1.m), "1.0 ms")
//        assertEquals(converter.fromString("1.0ms"), 1.m)
//
//        val primitiveConverter =
//            buildStringConverter {
//                fromString { it.toInt() }
//            }
//        assertEquals(primitiveConverter.toString(123), "123")
//        assertEquals(primitiveConverter.fromString("123"), 123)
//    }
//
//    @Test
//    fun invoke() {
//        assertEquals(intConverter.toString(123), intConverter(123))
//        assertEquals(defaultConverter.toString(null), defaultConverter(null))
//    }
//
//    @Test
//    fun get() {
//        assertEquals(intConverter.fromString("123"), intConverter["123"])
//        assertEquals(defaultConverter.fromString("Hello world"), defaultConverter["Hello world"])
//    }
}
