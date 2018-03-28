package ktfx.beans.value

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import ktfx.Person
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object ValueAccessorsSpec : Spek({

    given("string") {
        val stringProperty = SimpleStringProperty("Hello")
        var string: String by stringProperty
        it("getValue") {
            assertEquals(string, "Hello")
        }
        it("setValue") {
            string = "World"
            assertEquals(stringProperty.value, "World")
        }
    }

    given("boolean") {
        val booleanProperty = SimpleBooleanProperty(false)
        var boolean: Boolean by booleanProperty
        it("getValue") {
            assertEquals(boolean, false)
        }
        it("setValue") {
            boolean = true
            assertEquals(booleanProperty.value, true)
        }
    }

    given("integer") {
        val intProperty = SimpleIntegerProperty(1)
        var int: Int by intProperty
        it("getValue") {
            assertEquals(int, 1)
        }
        it("setValue") {
            int = 2
            assertEquals(intProperty.value, 2)
        }
    }

    given("any") {
        val person1 = Person("Hendra", 24)
        val person2 = Person("Hobo", 50)
        val personProperty = SimpleObjectProperty(person1)
        var person: Person by personProperty
        it("getValue") {
            assertEquals(person, person1)
        }
        it("setValue") {
            person = person2
            assertEquals(personProperty.value, person2)
        }
    }
})