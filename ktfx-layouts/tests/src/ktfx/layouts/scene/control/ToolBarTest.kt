package ktfx.layouts.scene.control

import javafx.scene.control.ToolBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.toolBar

class ToolBarTest : LayoutTest<NodeManager, ToolBar>() {

    override fun createManager() = KtfxPane()
    override fun create() = toolBar { }
    override fun NodeManager.add() = toolBar()
    override fun NodeManager.addWithBuilder() = toolBar { }
}