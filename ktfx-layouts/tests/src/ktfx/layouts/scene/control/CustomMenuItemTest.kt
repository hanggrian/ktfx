package ktfx.layouts.scene.control

import javafx.scene.control.CustomMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.MenuItemManager
import ktfx.layouts.customMenuItem
import ktfx.test.LayoutTest
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CustomMenuItemTest : LayoutTest<MenuItemManager, CustomMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun childCount() = manager.childCount
    override fun child1() = customMenuItem { }
    override fun MenuItemManager.child2() = customMenuItem()
    override fun MenuItemManager.child3() = customMenuItem { }

    override fun CustomMenuItem.testDefaultValues() {
        assertNull(content)
        assertTrue(isHideOnClick)
    }
}