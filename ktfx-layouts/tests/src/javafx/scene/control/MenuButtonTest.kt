package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.MenuButton
import ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuButtonTest : LayoutsTest<NodeManager, MenuButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = menuButton { }
    override fun NodeManager.child2() = menuButton()
    override fun NodeManager.child3() = menuButton { }

    override fun MenuButton.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }

    @Test fun stringInvocation() {
        menuButton {
            assertThat(items).isEmpty()
            menuItem("Hello")
            "World" {
            }
            // TODO("find out why line below throws error")
            // assertEquals(2, items.size)
        }
    }
}