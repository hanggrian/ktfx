package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.MaskerPane

class MaskerPaneTest : LayoutsTest<NodeManager, MaskerPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = maskerPane { }
    override fun NodeManager.child2() = maskerPane()
    override fun NodeManager.child3() = maskerPane { }
}