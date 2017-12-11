package kotfx

import kotfx.dialogs.alert
import org.junit.Assert.assertEquals

class DialogsTest {

    // @Rule
    // @JvmField
    val rule = JavaFXThreadingRule()

    // @Test
    fun alert() {
        alert("yo") {
            assertEquals(title, "")
        }
    }
}