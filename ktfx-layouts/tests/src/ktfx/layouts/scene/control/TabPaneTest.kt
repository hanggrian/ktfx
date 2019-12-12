package ktfx.layouts.scene.control

import javafx.scene.control.TabPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.tabPane
import ktfx.test.BaseLayoutTest

class TabPaneTest : BaseLayoutTest<NodeManager, TabPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = tabPane { }
    override fun NodeManager.child2() = tabPane()
    override fun NodeManager.child3() = tabPane { }
}