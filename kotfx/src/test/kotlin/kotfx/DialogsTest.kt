package kotfx

import org.junit.Assert.assertEquals

class DialogsTest {

    // @Rule
    // @JvmField
    val rule = JavaFXThreadingRule()

    // @Test
    fun simpleAlert() {
        alert("yo") {
            assertEquals(title, "")
        }
    }
}