package ktfx.layouts.scene.control

import javafx.scene.control.MenuBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.menu
import ktfx.layouts.menuBar
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuBarTest : LayoutTest<NodeManager, MenuBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = menuBar { }
    override fun NodeManager.child2() = menuBar()
    override fun NodeManager.child3() = menuBar { }

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