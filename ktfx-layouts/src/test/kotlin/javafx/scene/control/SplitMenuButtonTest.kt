package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.SplitMenuButton
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitMenuButtonTest : LayoutsTest<KtfxPane, SplitMenuButton>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): SplitMenuButton = splitMenuButton { }
    override fun KtfxPane.child2(): SplitMenuButton = splitMenuButton()
    override fun KtfxPane.child3(): SplitMenuButton = splitMenuButton { }

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
