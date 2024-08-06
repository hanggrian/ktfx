package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.MenuBar
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuBarTest : LayoutsTest<KtfxPane, MenuBar>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): MenuBar = menuBar { }

    override fun KtfxPane.child2(): MenuBar = menuBar()

    override fun KtfxPane.child3(): MenuBar = menuBar { }

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
