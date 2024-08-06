package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXListCell
import ktfx.layouts.KtfxPane

class JfxListCellTest : LayoutsTest<KtfxPane, JFXListCell<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXListCell<String> = jfxListCell<String> { }

    override fun KtfxPane.child2(): JFXListCell<String> = jfxListCell<String>()

    override fun KtfxPane.child3(): JFXListCell<String> = jfxListCell<String> { }
}
