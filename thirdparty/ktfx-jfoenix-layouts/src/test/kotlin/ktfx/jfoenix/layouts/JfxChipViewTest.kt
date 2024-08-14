package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane

class JfxChipViewTest : LayoutsStyledTest<KtfxPane, JFXChipView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxChipView<String> {}

    override fun KtfxPane.child2() = jfxChipView<String>()

    override fun child3() = styledJfxChipView<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxChipView<String>(styleClass = arrayOf("style"))
}
