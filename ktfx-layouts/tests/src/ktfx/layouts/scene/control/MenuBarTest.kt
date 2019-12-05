package ktfx.layouts.scene.control

import javafx.scene.control.MenuBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.menu
import ktfx.layouts.menuBar
import ktfx.test.assertEmpty
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuBarTest : LayoutTest<NodeManager, MenuBar>() {

    override fun createManager() = KtfxPane()
    override fun create() = menuBar { }
    override fun NodeManager.add() = menuBar()
    override fun NodeManager.addWithBuilder() = menuBar { }

    @Test fun stringInvocation() {
        menuBar {
            assertEmpty(menus)
            menu("Hello")
            "World" {
            }
            assertEquals(2, menus.size)
        }
    }
}