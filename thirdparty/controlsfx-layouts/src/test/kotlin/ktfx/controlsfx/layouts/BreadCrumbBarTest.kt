package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.BreadCrumbBar
import kotlin.test.assertNull

class BreadCrumbBarTest : LayoutsTest<KtfxPane, BreadCrumbBar<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): BreadCrumbBar<String> = breadCrumbBar<String> { }
    override fun KtfxPane.child2(): BreadCrumbBar<String> = breadCrumbBar<String>()
    override fun KtfxPane.child3(): BreadCrumbBar<String> = breadCrumbBar<String> { }

    override fun BreadCrumbBar<String>.testDefaultValues() {
        assertNull(selectedCrumb)
    }
}
