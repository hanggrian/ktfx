package ktfx.styles.scene.control

import javafx.scene.control.ToolBar
import ktfx.styles.NodeTest
import ktfx.styles.toolBarStyle

class ToolBarStyleTest : NodeTest<ToolBar>() {

    override fun newInstance() = ToolBar()

    override val style: String
        get() = toolBarStyle {
            // orientation = VERTICAL
        }

    override fun ToolBar.assertion() {
        // assertEquals(orientation, VERTICAL)
    }
}