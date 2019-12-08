package ktfx.layouts.scene.control

import javafx.scene.control.CheckMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.MenuItemManager
import ktfx.layouts.checkMenuItem
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class CheckMenuItemTest : LayoutTest<MenuItemManager, CheckMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun childCount() = manager.childCount
    override fun child1() = checkMenuItem { }
    override fun MenuItemManager.child2() = checkMenuItem()
    override fun MenuItemManager.child3() = checkMenuItem { }

    override fun CheckMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}