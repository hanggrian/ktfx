package ktfx.layouts.scene.control

import javafx.scene.control.Tab
import ktfx.layouts.KtfxTabPane
import ktfx.layouts.TabManager
import ktfx.layouts.tab
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class TabTest : LayoutTest<TabManager, Tab>() {

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