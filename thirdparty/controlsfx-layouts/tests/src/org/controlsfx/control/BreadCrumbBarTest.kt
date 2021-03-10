package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.BreadCrumbBar
import kotlin.test.assertNull

class BreadCrumbBarTest : LayoutsTest<KtfxPane, BreadCrumbBar<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = breadCrumbBar<String> { }
    override fun KtfxPane.child2() = breadCrumbBar<String>()
    override fun KtfxPane.child3() = breadCrumbBar<String> { }

    override fun BreadCrumbBar<String>.testDefaultValues() {
        assertNull(selectedCrumb)
    }
}