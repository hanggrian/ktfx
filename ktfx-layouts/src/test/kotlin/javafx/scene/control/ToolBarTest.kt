package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ToolBar
import javafx.scene.layout.Region
import kotlin.test.Test
import kotlin.test.assertIs

class ToolBarTest : LayoutsStyledTest<KtfxPane, ToolBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = toolBar {}

    override fun KtfxPane.child2() = toolBar()

    override fun child3() = styledToolBar()

    override fun KtfxPane.child4() = styledToolBar()

    @Test
    fun add() {
        toolBar {
            region()
            assertIs<Region>(items.single())
        }
    }
}
