package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.CheckTreeView
import kotlin.test.assertNull

class CheckTreeViewTest : LayoutsTest<KtfxPane, CheckTreeView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = checkTreeView<String> { }
    override fun KtfxPane.child2() = checkTreeView<String>()
    override fun KtfxPane.child3() = checkTreeView<String> { }

    override fun CheckTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}
