package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TitledPane
import javafx.scene.layout.Region
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNull

class TitledPaneTest : LayoutsStyledTest<KtfxPane, TitledPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = titledPane {}

    override fun KtfxPane.child2() = titledPane()

    override fun child3() = styledTitledPane()

    override fun KtfxPane.child4() = styledTitledPane()

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }

    @Test
    fun add() {
        titledPane {
            region()
            assertIs<Region>(content)
        }
    }
}
