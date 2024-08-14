package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.KtfxPane

class JfxToggleButtonTest : LayoutsStyledTest<KtfxPane, JFXToggleButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxToggleButton {}

    override fun KtfxPane.child2() = jfxToggleButton()

    override fun child3() = styledJfxToggleButton(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxToggleButton(styleClass = arrayOf("style"))
}
