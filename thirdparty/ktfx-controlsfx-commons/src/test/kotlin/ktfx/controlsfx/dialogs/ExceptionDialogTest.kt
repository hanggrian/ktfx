package ktfx.controlsfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import javafx.scene.control.ButtonType.OK
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.dialogs.icon
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class ExceptionDialogTest : DialogShowingTest() {
    @Test
    fun exceptionDialog() {
        interact {
            assertEquals(
                OK,
                exceptionDialog(UnsupportedOperationException()) {
                    headerTitle = "Exception dialog"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Exception dialog", headerText)
                    assertEquals("Exception dialog", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                }.get(),
            )
        }
    }
}
