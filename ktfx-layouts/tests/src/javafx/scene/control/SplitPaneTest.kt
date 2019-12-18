package ktfx.layouts

import javafx.scene.control.SplitPane
import ktfx.test.BaseLayoutTest

class SplitPaneTest : BaseLayoutTest<NodeManager, SplitPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = splitPane { }
    override fun NodeManager.child2() = splitPane()
    override fun NodeManager.child3() = splitPane { }
}