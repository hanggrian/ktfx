package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ToolBar

class ToolBarTest : LayoutsStyledTest<KtfxPane, ToolBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = toolBar {}

    override fun KtfxPane.child2() = toolBar()

    override fun child3() = styledToolBar(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledToolBar(styleClass = arrayOf("style"))
}
