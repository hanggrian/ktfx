package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.KtfxPane

class JfxMasonryPaneTest : LayoutsStyledTest<KtfxPane, JFXMasonryPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxMasonryPane {}

    override fun KtfxPane.child2() = jfxMasonryPane()

    override fun child3() = styledJfxMasonryPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxMasonryPane(styleClass = arrayOf("style"))
}
