package ktfx.layouts

import javafx.scene.control.Menu
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuTest : LayoutsTest<MenuItemManager, Menu>() {

    override fun manager() = KtfxMenu("", null)
    override fun childCount() = manager.childCount
    override fun child1() = menu { }
    override fun MenuItemManager.child2() = menu()
    override fun MenuItemManager.child3() = menu { }

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }
}