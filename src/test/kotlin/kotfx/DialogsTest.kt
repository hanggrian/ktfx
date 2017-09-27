package kotfx

import kotfx.dialogs.alert
import org.junit.Assert.assertEquals

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class DialogsTest {

    // @Rule
    // @JvmField
    val rule = JavaFXThreadingRule()

    // @Test
    fun alert() {
        alert("contentText").let {
            assertEquals(it.headerText, "")
            assertEquals(it.dialogPane.buttonTypes.size, 0)
        }
    }
}