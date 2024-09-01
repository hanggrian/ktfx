package ktfx.controlsfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.dialogs.icon
import org.controlsfx.dialog.CommandLinksDialog
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class CommandLinksDialogTest : DialogShowingTest() {
    @Test
    fun commandLinksDialogFromArray() {
        interact {
            assertEquals(
                "Yes",
                commandLinksDialog(CommandLinksDialog.CommandLinksButtonType("Yes", true)) {
                    headerTitle = "Command links dialog"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Command links dialog", headerText)
                    assertEquals("Command links dialog", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                }.get().text,
            )
        }
    }

    @Test
    fun commandLinksDialogFromList() {
        interact {
            assertEquals(
                "Yes",
                commandLinksDialog(listOf(CommandLinksDialog.CommandLinksButtonType("Yes", true))) {
                    headerTitle = "Command links dialog"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Command links dialog", headerText)
                    assertEquals("Command links dialog", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                }.get().text,
            )
        }
    }
}
