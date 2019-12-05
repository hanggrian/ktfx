package ktfx.layouts.scene.control

import javafx.scene.control.Menu
import ktfx.layouts.KtfxMenu
import ktfx.layouts.LayoutTest
import ktfx.layouts.MenuItemManager
import ktfx.layouts.menu
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuTest : LayoutTest<MenuItemManager, Menu>() {

    override fun createManager() = KtfxMenu("", null)
    override fun create() = menu { }
    override fun MenuItemManager.add() = menu()
    override fun MenuItemManager.addWithBuilder() = menu { }

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }
}