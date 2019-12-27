package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.StatusBar

class StatusBarTest : LayoutsTest<NodeManager, StatusBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = statusBar { }
    override fun NodeManager.child2() = statusBar()
    override fun NodeManager.child3() = statusBar { }
}