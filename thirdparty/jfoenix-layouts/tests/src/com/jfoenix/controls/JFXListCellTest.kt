package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXListCellTest : LayoutsTest<KtfxPane, JFXListCell<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxListCell<String> { }
    override fun KtfxPane.child2() = jfxListCell<String>()
    override fun KtfxPane.child3() = jfxListCell<String> { }
}