package kfx.listeners

import javafx.util.StringConverter
import kfx.listeners.StringConverterSpec.stringConverter
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object StringConverterSpec : Spek({

    given("a primitive converter converter") {
        val converter = stringConverter<Int> {
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
    }
}) {

    inline fun <T> stringConverter(builder: StringConverterBuilder<T>.() -> Unit): StringConverter<T> =
        _StringConverterBuilder<T>().apply(builder)
}