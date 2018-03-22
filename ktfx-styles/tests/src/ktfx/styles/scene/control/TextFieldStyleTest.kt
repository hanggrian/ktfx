package ktfx.styles.scene.control

import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.control.TextField
import ktfx.styles.NodeTest
import ktfx.styles.textFieldStyle
import kotlin.test.assertEquals

class TextFieldStyleTest : NodeTest<TextField>() {

    override fun newInstance() = TextField("Hello world")

    override val style: String
        get() = textFieldStyle {
            alignment = TOP_RIGHT
        }

    override fun TextField.assertion() {
        assertEquals(alignment, TOP_RIGHT)
    }
}