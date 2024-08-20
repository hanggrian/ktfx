package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Tab
import javafx.scene.layout.Region
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNull

class TabTest : LayoutsStyledTest<KtfxTabPane, Tab>() {
    override fun manager() = KtfxTabPane()

    override fun KtfxTabPane.childCount() = tabs.size

    override fun child1() = tab {}

    override fun KtfxTabPane.child2() = tab()

    override fun child3() = styledTab()

    override fun KtfxTabPane.child4() = styledTab()

    override fun Tab.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }

    @Test
    fun add() {
        tab {
            region()
            assertIs<Region>(content)
        }
    }
}
