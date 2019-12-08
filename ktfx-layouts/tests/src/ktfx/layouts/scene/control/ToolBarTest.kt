package ktfx.layouts.scene.control

import javafx.scene.control.ToolBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.toolBar
import ktfx.test.LayoutTest

class ToolBarTest : LayoutTest<NodeManager, ToolBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = toolBar { }
    override fun NodeManager.child2() = toolBar()
    override fun NodeManager.child3() = toolBar { }
}