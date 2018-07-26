package javafxx.beans.value

import javafx.beans.property.SimpleObjectProperty
import javafxx.Person
import org.junit.Test
import kotlin.test.assertEquals

class AnyValueTest {
    private val person1 = Person("Hendra", 24)
    private val person2 = Person("Hobo", 50)
    private val personProperty = SimpleObjectProperty(person1)
    private var person: Person by personProperty

    @Test fun any() {
        assertEquals(person, person1)
        person = person2
        assertEquals(personProperty.value, person2)
    }
}