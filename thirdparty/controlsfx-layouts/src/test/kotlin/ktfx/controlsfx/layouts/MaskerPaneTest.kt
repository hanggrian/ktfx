package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.MaskerPane

class MaskerPaneTest : LayoutsTest<KtfxPane, MaskerPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): MaskerPane = maskerPane { }
    override fun KtfxPane.child2(): MaskerPane = maskerPane()
    override fun KtfxPane.child3(): MaskerPane = maskerPane { }
}
