package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.KtfxPane

class JfxTreeCellTest : LayoutsStyledTest<KtfxPane, JFXTreeCell<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTreeCell<String> {}

    override fun KtfxPane.child2() = jfxTreeCell<String>()

    override fun child3() = styledJfxTreeCell<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxTreeCell<String>(styleClass = arrayOf("style"))
}
