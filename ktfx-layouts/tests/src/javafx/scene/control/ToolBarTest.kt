package ktfx.layouts

import javafx.scene.control.ToolBar
import com.hendraanggrian.ktfx.test.LayoutsTest

class ToolBarTest : LayoutsTest<KtfxPane, ToolBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = toolBar { }
    override fun KtfxPane.child2() = toolBar()
    override fun KtfxPane.child3() = toolBar { }
}
