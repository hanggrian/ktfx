package ktfx.layouts

import javafx.scene.control.Tab
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class TabTest : BaseLayoutTest<TabManager, Tab>() {

    override fun manager() = KtfxTabPane()
    override fun childCount() = manager.childCount
    override fun child1() = tab { }
    override fun TabManager.child2() = tab()
    override fun TabManager.child3() = tab { }

    override fun Tab.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}