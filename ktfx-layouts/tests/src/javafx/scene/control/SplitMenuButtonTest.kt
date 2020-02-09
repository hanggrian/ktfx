package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.SplitMenuButton
import ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitMenuButtonTest : LayoutsTest<KtfxPane, SplitMenuButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = splitMenuButton { }
    override fun KtfxPane.child2() = splitMenuButton()
    override fun KtfxPane.child3() = splitMenuButton { }

    @Test fun stringInvocation() {
        splitMenuButton {
            assertThat(items).isEmpty()
            menuItem("Hello")
            "World" {
            }
            assertEquals(2, items.size)
        }
    }
}