package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class JFXTreeCellTest : LayoutsTest<KtfxPane, JFXTreeCell<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTreeCell<String> { }
    override fun KtfxPane.child2() = jfxTreeCell<String>()
    override fun KtfxPane.child3() = jfxTreeCell<String> { }
}