package ktfx.layouts.scene.control

import javafx.scene.control.CustomMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.LayoutTest
import ktfx.layouts.MenuItemManager
import ktfx.layouts.customMenuItem
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CustomMenuItemTest : LayoutTest<MenuItemManager, CustomMenuItem>() {

    override fun createManager() = KtfxMenu("", null)
    override fun create() = customMenuItem { }
    override fun MenuItemManager.add() = customMenuItem()
    override fun MenuItemManager.addWithBuilder() = customMenuItem { }

    override fun CustomMenuItem.testDefaultValues() {
        assertNull(content)
        assertTrue(isHideOnClick)
    }
}