package ktfx.layouts.scene.control

import javafx.scene.control.RadioMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.MenuItemManager
import ktfx.layouts.radioMenuItem
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class RadioMenuItemTest : LayoutTest<MenuItemManager, RadioMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun childCount() = manager.childCount
    override fun child1() = radioMenuItem { }
    override fun MenuItemManager.child2() = radioMenuItem()
    override fun MenuItemManager.child3() = radioMenuItem { }

    override fun RadioMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}