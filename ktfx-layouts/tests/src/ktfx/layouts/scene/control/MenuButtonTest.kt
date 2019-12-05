package ktfx.layouts.scene.control

import javafx.scene.control.MenuButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.menuButton
import ktfx.layouts.menuItem
import ktfx.test.assertEmpty
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuButtonTest : LayoutTest<NodeManager, MenuButton>(KtfxPane()) {

    override fun create() = menuButton { }
    override fun NodeManager.add() = menuButton()
    override fun NodeManager.addWithBuilder() = menuButton { }

    override fun MenuButton.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }

    @Test fun stringInvocation() {
        menuButton {
            assertEmpty(items)
            menuItem("Hello")
            "World" {
            }
            // TODO("find out why line below throws error")
            // assertEquals(2, items.size)
        }
    }
}