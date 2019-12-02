package ktfx.dialogs

import com.google.common.truth.Truth
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import ktfx.test.assertInstance
import kotlin.test.Ignore
import kotlin.test.assertEquals

@Ignore("Error when executed from terminal, test manually instead")
class InputDialogTest : ShowDialogTest() {
    private lateinit var inputDialog1: TextInputDialog
    private lateinit var inputDialog2: TextInputDialog
    private val inputResults = mutableSetOf<String>()

    override fun show() {
        inputResults += inputDialog("Input dialog", ImageView("file:icon.png"), "Awful input") {
            inputDialog1 = this
            editor.text = "Awesome input"
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        inputResults += inputDialog("Awful input") {
            inputDialog2 = this
            editor.text = "Awesome input"
            setOnShown { push(KeyCode.ENTER) }
        }.get()
    }

    override fun test() {
        assertEquals("Input dialog", inputDialog1.headerText)
        assertInstance<ImageView>(inputDialog1.graphic)
        assertEquals("Awful input", inputDialog1.defaultValue)
        assertEquals("Awful input", inputDialog2.defaultValue)
        Truth.assertThat(inputResults).containsExactly("Awesome input")
    }
}