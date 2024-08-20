package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.MenuButton
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuButtonTest : LayoutsStyledTest<KtfxPane, MenuButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = menuButton {}

    override fun KtfxPane.child2() = menuButton()

    override fun child3() = styledMenuButton()

    override fun KtfxPane.child4() = styledMenuButton()

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
            // TODO find out why line below throws error
            // assertEquals(2, items.size)
        }
    }
}
