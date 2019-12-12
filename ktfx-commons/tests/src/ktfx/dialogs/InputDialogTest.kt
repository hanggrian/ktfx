package ktfx.dialogs

import javafx.scene.image.ImageView
import ktfx.test.DialogShowingTest
import ktfx.test.assertInstance
import org.testfx.api.FxRobot
import kotlin.test.Test
import kotlin.test.assertEquals

class InputDialogTest : DialogShowingTest() {

    @Test fun FxRobot.inputDialog() {
        interact {
            assertEquals("Awesome input", inputDialog("Input dialog", ImageView("file:icon.png"), "Awful input") {
                closeOnShow(this)
                assertEquals("Input dialog", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Awful input", defaultValue)
                editor.text = "Awesome input"
            }.get())
            assertEquals("Awesome input", inputDialog("Awful input") {
                closeOnShow(this)
                assertEquals("Awful input", defaultValue)
                editor.text = "Awesome input"
            }.get())
        }
    }
}