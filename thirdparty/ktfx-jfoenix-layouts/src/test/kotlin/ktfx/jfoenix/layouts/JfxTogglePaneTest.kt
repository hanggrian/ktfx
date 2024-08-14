package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTogglePane
import ktfx.layouts.KtfxPane

class JfxTogglePaneTest : LayoutsStyledTest<KtfxPane, JFXTogglePane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTogglePane {}

    override fun KtfxPane.child2() = jfxTogglePane()

    override fun child3() = styledJfxTogglePane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxTogglePane(styleClass = arrayOf("style"))
}
