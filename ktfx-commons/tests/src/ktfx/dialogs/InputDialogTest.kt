package ktfx.dialogs

import javafx.scene.image.ImageView
import ktfx.test.DialogApplicationTest
import ktfx.test.assertInstance
import kotlin.test.Test
import kotlin.test.assertEquals

class InputDialogTest : DialogApplicationTest() {

    @Test fun inputDialog() {
        interact {
            assertEquals("Awesome input", inputDialog("Input dialog", ImageView("file:icon.png"), "Awful input") {
                closeOnShow()
                assertEquals("Input dialog", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Awful input", defaultValue)
                editor.text = "Awesome input"
            }.get())
            assertEquals("Awesome input", inputDialog("Awful input") {
                closeOnShow()
                assertEquals("Awful input", defaultValue)
                editor.text = "Awesome input"
            }.get())
        }
    }
}