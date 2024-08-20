package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ScrollPane
import javafx.scene.layout.Region
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNull

class ScrollPaneTest : LayoutsStyledTest<KtfxPane, ScrollPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = scrollPane {}

    override fun KtfxPane.child2() = scrollPane()

    override fun child3() = styledScrollPane()

    override fun KtfxPane.child4() = styledScrollPane()

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }

    @Test
    fun add() {
        scrollPane {
            region()
            assertIs<Region>(content)
        }
    }
}
