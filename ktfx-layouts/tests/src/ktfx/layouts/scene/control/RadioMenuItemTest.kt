package ktfx.layouts.scene.control

import javafx.scene.control.RadioMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.LayoutTest
import ktfx.layouts.MenuItemManager
import ktfx.layouts.radioMenuItem
import kotlin.test.assertNull

class RadioMenuItemTest : LayoutTest<MenuItemManager, RadioMenuItem>() {

    override fun createManager() = KtfxMenu("", null)
    override fun create() = radioMenuItem { }
    override fun MenuItemManager.add() = radioMenuItem()
    override fun MenuItemManager.addWithBuilder() = radioMenuItem { }

    override fun RadioMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}