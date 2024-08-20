package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.SplitPane
import javafx.scene.layout.Region
import kotlin.test.Test
import kotlin.test.assertIs

class SplitPaneTest : LayoutsStyledTest<KtfxPane, SplitPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = splitPane {}

    override fun KtfxPane.child2() = splitPane()

    override fun child3() = styledSplitPane()

    override fun KtfxPane.child4() = styledSplitPane()

    @Test
    fun add() {
        splitPane {
            region()
            assertIs<Region>(items.single())
        }
    }
}
