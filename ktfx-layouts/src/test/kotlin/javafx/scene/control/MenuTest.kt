package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull

class MenuTest : LayoutsStyledTest<KtfxMenu, Menu>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = menu {}

    override fun KtfxMenu.child2() = menu()

    override fun child3() = styledMenu()

    override fun KtfxMenu.child4() = styledMenu()

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }

    @Test
    fun stringInvocation() {
        menu {
            assertThat(items).isEmpty()
            menuItem("Hello")
            "World" {
            }
            assertEquals(2, items.size)
            assertIs<MenuItem>(items.last())
        }
    }
}
