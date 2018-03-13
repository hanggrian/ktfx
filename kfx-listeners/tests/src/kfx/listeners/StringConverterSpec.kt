package kfx.listeners

import org.jetbrains.spek.api.Spek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
object StringConverterSpec : Spek({

    /*given("a primitive string converter") {
        val converter = _StringConverterBuilder<Int> {
            fromString { it.toInt() }
        }
        it("should convert back and forth") {
            assertEquals(converter.toString(123), "123")
            assertEquals(converter.fromString("123"), 123)
        }
    }

    given("a custom object string converter") {
        val converter = stringConverter<Person> {
            toString { it!!.name }
            fromString { Person(it) }
        }
        it("should convert back and forth") {
            assertEquals(converter.toString(Person("Hendra")), "Hendra")
            assertEquals(converter.fromString("Hendra"), Person("Hendra"))
        }
    }*/
})