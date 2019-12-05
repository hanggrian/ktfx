package ktfx.layouts.scene.control

import javafx.scene.control.MenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.LayoutTest
import ktfx.layouts.MenuItemManager
import ktfx.layouts.menuItem
import kotlin.test.assertNull

class MenuItemTest : LayoutTest<MenuItemManager, MenuItem>() {

    override fun createManager() = KtfxMenu("", null)
    override fun create() = menuItem { }
    override fun MenuItemManager.add() = menuItem()
    override fun MenuItemManager.addWithBuilder() = menuItem { }

    override fun MenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}