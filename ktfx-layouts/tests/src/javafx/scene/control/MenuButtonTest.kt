package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.MenuButton
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuButtonTest : LayoutsTest<KtfxPane, MenuButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = menuButton { }
    override fun KtfxPane.child2() = menuButton()
    override fun KtfxPane.child3() = menuButton { }

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