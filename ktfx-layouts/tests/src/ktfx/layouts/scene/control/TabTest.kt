package ktfx.layouts.scene.control

import javafx.scene.control.Tab
import ktfx.layouts.KtfxTabPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.TabManager
import ktfx.layouts.tab
import kotlin.test.assertNull

class TabTest : LayoutTest<TabManager, Tab>() {

    override fun createManager() = KtfxTabPane()
    override fun create() = tab { }
    override fun TabManager.add() = tab()
    override fun TabManager.addWithBuilder() = tab { }

    override fun Tab.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}