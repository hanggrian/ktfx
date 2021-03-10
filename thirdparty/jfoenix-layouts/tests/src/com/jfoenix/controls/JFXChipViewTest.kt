package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class JFXChipViewTest : LayoutsTest<KtfxPane, JFXChipView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxChipView<String> { }
    override fun KtfxPane.child2() = jfxChipView<String>()
    override fun KtfxPane.child3() = jfxChipView<String> { }
}