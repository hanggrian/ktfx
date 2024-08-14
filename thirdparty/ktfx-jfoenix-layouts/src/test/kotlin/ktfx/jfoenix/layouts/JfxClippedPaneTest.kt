package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXClippedPane
import ktfx.layouts.KtfxPane

class JfxClippedPaneTest : LayoutsStyledTest<KtfxPane, JFXClippedPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxClippedPane {}

    override fun KtfxPane.child2() = jfxClippedPane()

    override fun child3() = styledJfxClippedPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxClippedPane(styleClass = arrayOf("style"))
}
