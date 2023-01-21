package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.MenuButton
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuButtonTest : LayoutsTest<KtfxPane, MenuButton>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): MenuButton = menuButton { }
    override fun KtfxPane.child2(): MenuButton = menuButton()
    override fun KtfxPane.child3(): MenuButton = menuButton { }

    override fun MenuButton.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }

    @Test
    fun stringInvocation() {
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
