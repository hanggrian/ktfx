package ktfx.layouts

import javafx.scene.control.CheckMenuItem
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class CheckMenuItemTest : LayoutsTest<MenuItemManager, CheckMenuItem>() {

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