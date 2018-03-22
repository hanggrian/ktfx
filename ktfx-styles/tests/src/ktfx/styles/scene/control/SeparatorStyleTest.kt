package ktfx.styles.scene.control

import javafx.geometry.HPos.RIGHT
import javafx.geometry.Orientation.VERTICAL
import javafx.geometry.VPos.BOTTOM
import javafx.scene.control.Separator
import ktfx.styles.NodeTest
import ktfx.styles.separatorStyle
import kotlin.test.assertEquals

class SeparatorStyleTest : NodeTest<Separator>() {

    override fun newInstance() = Separator()

    override val style: String
        get() = separatorStyle {
            orientation = VERTICAL
            halignment = RIGHT
            valignment = BOTTOM
        }

    override fun Separator.assertion() {
        assertEquals(orientation, VERTICAL)
        assertEquals(halignment, RIGHT)
        assertEquals(valignment, BOTTOM)
    }
}