package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.KtfxPane

class JfxTreeCellTest : LayoutsTest<KtfxPane, JFXTreeCell<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXTreeCell<String> = jfxTreeCell { }

    override fun KtfxPane.child2(): JFXTreeCell<String> = jfxTreeCell()

    override fun KtfxPane.child3(): JFXTreeCell<String> = jfxTreeCell { }
}
