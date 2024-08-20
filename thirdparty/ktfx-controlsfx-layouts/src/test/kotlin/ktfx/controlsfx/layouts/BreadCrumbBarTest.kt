package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.BreadCrumbBar
import kotlin.test.assertNull

class BreadCrumbBarTest : LayoutsStyledTest<KtfxPane, BreadCrumbBar<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = breadCrumbBar<String> {}

    override fun KtfxPane.child2() = breadCrumbBar<String>()

    override fun child3() = styledBreadCrumbBar<String>()

    override fun KtfxPane.child4() = styledBreadCrumbBar<String>()

    override fun BreadCrumbBar<String>.testDefaultValues() {
        assertNull(selectedCrumb)
    }
}
