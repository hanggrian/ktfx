package ktfx.layouts.scene.control

import javafx.scene.control.SeparatorMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.LayoutTest
import ktfx.layouts.MenuItemManager
import ktfx.layouts.separatorMenuItem

class SeparatorMenuItemTest : LayoutTest<MenuItemManager, SeparatorMenuItem>() {

    override fun createManager() = KtfxMenu("", null)
    override fun create() = separatorMenuItem { }
    override fun MenuItemManager.add() = separatorMenuItem()
    override fun MenuItemManager.addWithBuilder() = separatorMenuItem { }
}