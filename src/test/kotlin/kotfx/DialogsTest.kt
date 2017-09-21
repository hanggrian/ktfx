package kotfx

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class DialogsTest {

    // @get:Rule
    val rule
        get() = JavaFXThreadingRule()

    // @Test
    fun alert() {
        kotfx.dialogs.alert("")
        kotfx.dialogs.alert("") {}

        kotfx.dialogs.alert("", "")
        kotfx.dialogs.alert("", "") {}
    }
}