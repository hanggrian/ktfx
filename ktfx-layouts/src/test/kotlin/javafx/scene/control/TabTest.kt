package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Tab
import kotlin.test.assertNull

class TabTest : LayoutsTest<KtfxTabPane, Tab>() {
    override fun manager(): KtfxTabPane = KtfxTabPane()
    override fun KtfxTabPane.childCount(): Int = tabs.size
    override fun child1(): Tab = tab { }
    override fun KtfxTabPane.child2(): Tab = tab()
    override fun KtfxTabPane.child3(): Tab = tab { }

    override fun Tab.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
