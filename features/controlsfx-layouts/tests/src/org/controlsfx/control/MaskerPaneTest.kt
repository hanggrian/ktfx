package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.MaskerPane

class MaskerPaneTest : LayoutsTest<KtfxPane, MaskerPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = maskerPane { }
    override fun KtfxPane.child2() = maskerPane()
    override fun KtfxPane.child3() = maskerPane { }
}