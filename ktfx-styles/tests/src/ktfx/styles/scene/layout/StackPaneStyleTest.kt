package ktfx.styles.scene.layout

import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.layout.StackPane
import ktfx.styles.NodeTest
import ktfx.styles.stackPaneStyle
import kotlin.test.assertEquals

class StackPaneStyleTest : NodeTest<StackPane>() {

    override fun newInstance() = StackPane()

    override val style: String
        get() = stackPaneStyle(true) {
            alignment = TOP_RIGHT
        }

    override fun StackPane.assertion() {
        assertEquals(alignment, TOP_RIGHT)
    }
}