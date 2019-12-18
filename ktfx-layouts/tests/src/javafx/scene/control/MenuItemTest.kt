package ktfx.layouts

import javafx.scene.control.MenuItem
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class MenuItemTest : BaseLayoutTest<MenuItemManager, MenuItem>() {

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