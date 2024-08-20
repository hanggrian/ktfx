package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXListCell
import ktfx.layouts.KtfxPane

class JfxListCellTest : LayoutsStyledTest<KtfxPane, JFXListCell<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxListCell<String> {}

    override fun KtfxPane.child2() = jfxListCell<String>()

    override fun child3() = styledJfxListCell<String>()

    override fun KtfxPane.child4() = styledJfxListCell<String>()
}
