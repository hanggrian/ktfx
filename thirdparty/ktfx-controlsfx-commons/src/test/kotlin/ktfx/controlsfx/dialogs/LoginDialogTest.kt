package ktfx.controlsfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.dialogs.icon
import ktfx.toFxPair
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class LoginDialogTest : DialogShowingTest() {
    private val userInfo = "Hello" to "World"

    @Test
    fun exceptionDialog() {
        interact {
            assertEquals(
                userInfo.toFxPair(),
                loginDialog(userInfo, {}) {
                    headerTitle = "Login dialog"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Login dialog", headerText)
                    assertEquals("Login dialog", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                }.get(),
            )
            assertEquals(
                userInfo.toFxPair(),
                loginDialog(userInfo, {}) { closeOnShow(this) }.get(),
            )
        }
    }
}
