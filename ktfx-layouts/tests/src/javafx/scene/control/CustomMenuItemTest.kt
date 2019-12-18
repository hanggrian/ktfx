package ktfx.layouts

import javafx.scene.control.CustomMenuItem
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CustomMenuItemTest : BaseLayoutTest<MenuItemManager, CustomMenuItem>() {

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