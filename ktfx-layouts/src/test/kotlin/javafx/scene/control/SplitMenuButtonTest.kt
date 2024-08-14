package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.SplitMenuButton
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitMenuButtonTest : LayoutsStyledTest<KtfxPane, SplitMenuButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = splitMenuButton {}

    override fun KtfxPane.child2() = splitMenuButton()

    override fun child3() = styledSplitMenuButton(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledSplitMenuButton(styleClass = arrayOf("style"))

    @Test
    fun stringInvocation() {
        splitMenuButton {
            assertThat(items).isEmpty()
            menuItem("Hello")
            "World" {
            }
            assertEquals(2, items.size)
        }
    }
}
