package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXTreeViewTest : LayoutsTest<KtfxPane, JFXTreeView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTreeView<String> { }
    override fun KtfxPane.child2() = jfxTreeView<String>()
    override fun KtfxPane.child3() = jfxTreeView<String> { }

    override fun JFXTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}
