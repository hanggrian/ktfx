package ktfx.controlsfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import org.controlsfx.dialog.CommandLinksDialog
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class CommandLinksDialogsTest : DialogShowingTest() {

    @Test fun commandLinksDialogFromArray() {
        interact {
            assertEquals(
                "Yes",
                commandLinksDialog(
                    "Command links dialog", sampleGraphic,
                    CommandLinksDialog.CommandLinksButtonType("Yes", true)
                ) {
                    closeOnShow(this)
                    assertEquals("Command links dialog", headerText)
                    assertEquals(sampleGraphic, graphic)
                }.get().text
            )
            assertEquals("Yes", commandLinksDialog(CommandLinksDialog.CommandLinksButtonType("Yes", true)) {
                closeOnShow(this)
            }.get().text)
        }
    }

    @Test fun commandLinksDialogFromList() {
        interact {
            assertEquals(
                "Yes",
                commandLinksDialog(
                    "Command links dialog", sampleGraphic,
                    listOf(CommandLinksDialog.CommandLinksButtonType("Yes", true))
                ) {
                    closeOnShow(this)
                    assertEquals("Command links dialog", headerText)
                    assertEquals(sampleGraphic, graphic)
                }.get().text
            )
            assertEquals("Yes", commandLinksDialog(listOf(CommandLinksDialog.CommandLinksButtonType("Yes", true))) {
                closeOnShow(this)
            }.get().text)
        }
    }
}