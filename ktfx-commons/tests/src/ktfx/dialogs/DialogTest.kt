package ktfx.dialogs

import javafx.scene.control.Dialog
import ktfx.controls.stage
import ktfx.test.DialogShowingTest
import ktfx.test.assertEmpty
import ktfx.test.assertNotEmpty
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

@Ignore
class DialogTest : DialogShowingTest() {

    @Test fun graphicIcon() {
        interact {
            val dialog = Dialog<Nothing>()
            assertEmpty(dialog.dialogPane.scene.stage.icons)
            assertNull(dialog.graphic)
            dialog.graphicIcon = sampleGraphic
            assertNotEmpty(dialog.dialogPane.scene.stage.icons)
            assertEquals(sampleGraphic, dialog.graphic)
        }
    }

    @Test fun headerTitle() {
        interact {
            val dialog = Dialog<Nothing>()
            assertNull(dialog.headerText)
            assertNull(dialog.title)
            dialog.headerTitle = "Hello World"
            assertEquals("Hello World", dialog.headerText)
            assertEquals("Hello World", dialog.title)
        }
    }

    /** Because some dialog texts have space suffix, use [assertTrue] instead of [assertEquals]. */
    @Test fun buttons() {
        interact {
            val dialog = Dialog<Nothing>()
            dialog.buttons {
                apply { assertTrue("Apply" in text) }
                ok { assertTrue("OK" in text) }
                cancel { assertTrue("Cancel" in text) }
                close { assertTrue("Close" in text) }
                yes { assertTrue("Yes" in text) }
                no { assertTrue("No" in text) }
                finish { assertTrue("Finish" in text) }
                next { assertTrue("Next" in text) }
                previous { assertTrue("Previous" in text) }
                custom("Custom1") { assertEquals("Custom1", text) }
                "Custom2" { assertEquals("Custom2", text) }
            }
            assertEquals(11, dialog.dialogPane.buttonTypes.size)
        }
    }
}
