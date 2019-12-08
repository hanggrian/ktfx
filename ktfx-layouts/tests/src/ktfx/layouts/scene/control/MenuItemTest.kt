package ktfx.layouts.scene.control

import javafx.scene.control.MenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.MenuItemManager
import ktfx.layouts.menuItem
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class MenuItemTest : LayoutTest<MenuItemManager, MenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun childCount() = manager.childCount
    override fun child1() = menuItem { }
    override fun MenuItemManager.child2() = menuItem()
    override fun MenuItemManager.child3() = menuItem { }

    override fun MenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}