package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.BreadCrumbBar
import kotlin.test.assertNull

class BreadCrumbBarTest : LayoutTest<NodeManager, BreadCrumbBar<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = breadCrumbBar<String> { }
    override fun NodeManager.child2() = breadCrumbBar<String>()
    override fun NodeManager.child3() = breadCrumbBar<String> { }

    override fun BreadCrumbBar<String>.testDefaultValues() {
        assertNull(selectedCrumb)
    }
}