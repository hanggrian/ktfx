package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ScrollBar

class ScrollBarTest : LayoutsStyledTest<KtfxPane, ScrollBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = scrollBar {}

    override fun KtfxPane.child2() = scrollBar()

    override fun child3() = styledScrollBar(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledScrollBar(styleClass = arrayOf("style"))
}
