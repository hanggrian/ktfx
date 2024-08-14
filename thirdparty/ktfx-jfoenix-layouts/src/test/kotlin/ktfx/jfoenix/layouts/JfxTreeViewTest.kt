package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTreeView
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTreeViewTest : LayoutsStyledTest<KtfxPane, JFXTreeView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTreeView<String> {}

    override fun KtfxPane.child2() = jfxTreeView<String>()

    override fun child3() = styledJfxTreeView<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxTreeView<String>(styleClass = arrayOf("style"))

    override fun JFXTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}
