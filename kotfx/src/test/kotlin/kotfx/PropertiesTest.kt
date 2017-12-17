package kotfx

import org.junit.Assert.assertTrue
import org.junit.Test

class PropertiesTest {

    @Test fun boolean() = assertTrue(!false.asProperty().asObservable().value)
    @Test fun double() = assertTrue(Double.MIN_VALUE.asProperty().asObservable().value == Double.MIN_VALUE)
    @Test fun float() = assertTrue(Float.MIN_VALUE.asProperty().asObservable().value == Float.MIN_VALUE)
    @Test fun int() = assertTrue(Int.MIN_VALUE.asProperty().asObservable().value == Int.MIN_VALUE)
    @Test fun list() = assertTrue(emptyList<Int>().asProperty().asObservable().value == emptyList<Int>())
    @Test fun long() = assertTrue(Long.MIN_VALUE.asProperty().asObservable().value == Long.MIN_VALUE)
    @Test fun map() = assertTrue(emptyMap<Int, Int>().asProperty().asObservable().value == emptyMap<Int, Int>())
    @Test fun `object`() = assertTrue(Person.asProperty().asObservable().value == Person)
    @Test fun set() = assertTrue(emptySet<Int>().asProperty().asObservable().value == emptySet<Int>())
    @Test fun string() = assertTrue("".asProperty().asObservable().value == "")

    open class Person {
        companion object : Person()
    }
}