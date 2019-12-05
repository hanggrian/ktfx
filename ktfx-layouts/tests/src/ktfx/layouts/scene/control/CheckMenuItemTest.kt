package ktfx.layouts.scene.control

import javafx.scene.control.CheckMenuItem
import ktfx.layouts.KtfxMenu
import ktfx.layouts.LayoutTest
import ktfx.layouts.MenuItemManager
import ktfx.layouts.checkMenuItem
import kotlin.test.assertNull

class CheckMenuItemTest : LayoutTest<MenuItemManager, CheckMenuItem>(KtfxMenu("", null)) {

    override fun create() = checkMenuItem { }
    override fun MenuItemManager.add() = checkMenuItem()
    override fun MenuItemManager.addWithBuilder() = checkMenuItem { }

    override fun CheckMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}