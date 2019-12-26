package ktfx.layouts

import javafx.scene.control.TabPane
import ktfx.test.LayoutTest

class TabPaneTest : LayoutTest<NodeManager, TabPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = tabPane { }
    override fun NodeManager.child2() = tabPane()
    override fun NodeManager.child3() = tabPane { }
}