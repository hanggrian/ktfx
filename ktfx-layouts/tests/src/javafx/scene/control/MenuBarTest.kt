package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.MenuBar
import ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuBarTest : LayoutsTest<NodeManager, MenuBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = menuBar { }
    override fun NodeManager.child2() = menuBar()
    override fun NodeManager.child3() = menuBar { }

    @Test fun stringInvocation() {
        menuBar {
            assertThat(menus).isEmpty()
            menu("Hello")
            "World" {
            }
            assertEquals(2, menus.size)
        }
    }
}