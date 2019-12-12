package ktfx.layouts.scene.control

import javafx.scene.control.SeparatorMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.MenuItemManager
import ktfx.layouts.separatorMenuItem
import ktfx.test.BaseLayoutTest

class SeparatorMenuItemTest : BaseLayoutTest<MenuItemManager, SeparatorMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun childCount() = manager.childCount
    override fun child1() = separatorMenuItem { }
    override fun MenuItemManager.child2() = separatorMenuItem()
    override fun MenuItemManager.child3() = separatorMenuItem { }
}