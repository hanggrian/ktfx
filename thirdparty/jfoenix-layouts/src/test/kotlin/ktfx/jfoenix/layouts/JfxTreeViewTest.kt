package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTreeView
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTreeViewTest : LayoutsTest<KtfxPane, JFXTreeView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXTreeView<String> = jfxTreeView { }
    override fun KtfxPane.child2(): JFXTreeView<String> = jfxTreeView()
    override fun KtfxPane.child3(): JFXTreeView<String> = jfxTreeView { }

    override fun JFXTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}
