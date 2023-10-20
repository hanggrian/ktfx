package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane

class JfxChipViewTest : LayoutsTest<KtfxPane, JFXChipView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXChipView<String> = jfxChipView { }

    override fun KtfxPane.child2(): JFXChipView<String> = jfxChipView()

    override fun KtfxPane.child3(): JFXChipView<String> = jfxChipView { }
}
