package ktfx

import javafx.beans.property.SimpleStringProperty
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingsOperatorStringTest {

    @Test fun eq() {
        assertFalse((SimpleStringProperty() eq SimpleStringProperty("Hendra")).value)
        assertTrue((SimpleStringProperty("Anggrian") eq SimpleStringProperty("Anggrian")).value)
    }

    @Test fun neq() {
        assertTrue((SimpleStringProperty() neq SimpleStringProperty("Hendra")).value)
        assertFalse((SimpleStringProperty("Anggrian") neq SimpleStringProperty("Anggrian")).value)
    }
}
