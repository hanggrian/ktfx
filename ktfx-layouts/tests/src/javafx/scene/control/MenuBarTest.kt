package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.MenuBar
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuBarTest : LayoutsTest<KtfxPane, MenuBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = menuBar { }
    override fun KtfxPane.child2() = menuBar()
    override fun KtfxPane.child3() = menuBar { }

    @Test
    fun stringInvocation() {
        menuBar {
            assertThat(menus).isEmpty()
            menu("Hello")
            "World" {
            }
            assertEquals(2, menus.size)
        }
    }
}