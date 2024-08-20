package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.MaskerPane

class MaskerPaneTest : LayoutsStyledTest<KtfxPane, MaskerPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = maskerPane {}

    override fun KtfxPane.child2() = maskerPane()

    override fun child3() = styledMaskerPane()

    override fun KtfxPane.child4() = styledMaskerPane()
}
