package ktfx.layouts

import javafx.scene.control.ToolBar
import ktfx.test.LayoutTest

class ToolBarTest : LayoutTest<NodeManager, ToolBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = toolBar { }
    override fun NodeManager.child2() = toolBar()
    override fun NodeManager.child3() = toolBar { }
}