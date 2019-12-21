package ktfx.dialogs

import javafx.scene.image.ImageView
import ktfx.test.BaseDialogTest
import ktfx.test.assertInstance
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class InputDialogTest : BaseDialogTest() {

    @Test fun inputDialog() {
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
