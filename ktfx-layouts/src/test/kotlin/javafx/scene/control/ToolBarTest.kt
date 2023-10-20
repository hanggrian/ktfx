package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ToolBar

class ToolBarTest : LayoutsTest<KtfxPane, ToolBar>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ToolBar = toolBar { }

    override fun KtfxPane.child2(): ToolBar = toolBar()

    override fun KtfxPane.child3(): ToolBar = toolBar { }
}
