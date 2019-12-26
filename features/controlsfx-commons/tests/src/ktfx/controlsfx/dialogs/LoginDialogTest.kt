package ktfx.controlsfx.dialogs

import ktfx.test.DialogShowingTest
import ktfx.util.toFxPair
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class LoginDialogTest : DialogShowingTest() {

    private val userInfo = "Hello" to "World"

    @Test fun exceptionDialog() {
        interact {
            assertEquals(
                userInfo.toFxPair(),
                loginDialog("Login dialog", sampleGraphic, userInfo, {}) {
                    closeOnShow(this)
                    assertEquals("Login dialog", headerText)
                    assertEquals(sampleGraphic, graphic)
                }.get()
            )
            assertEquals(userInfo.toFxPair(), loginDialog(userInfo, {}) { closeOnShow(this) }.get())
        }
    }
}