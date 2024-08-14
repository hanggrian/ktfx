package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.MenuBar
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuBarTest : LayoutsStyledTest<KtfxPane, MenuBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = menuBar {}

    override fun KtfxPane.child2() = menuBar()

    override fun child3() = styledMenuBar(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledMenuBar(styleClass = arrayOf("style"))

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
