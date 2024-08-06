package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXToolbar
import ktfx.layouts.KtfxPane
import kotlin.test.Test

class JfxToolbarTest : LayoutsTest<KtfxPane, JFXToolbar>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXToolbar = jfxToolbar { }

    override fun KtfxPane.child2(): JFXToolbar = jfxToolbar()

    override fun KtfxPane.child3(): JFXToolbar = jfxToolbar { }

    @Test
    fun leftAndRightItems() {
        val left1: JFXButton
        val right1: JFXButton
        val right2: JFXButton
        jfxToolbar {
            leftItems {
                left1 = jfxButton()
            }
            rightItems {
                right1 = jfxButton()
                right2 = jfxButton()
            }
            assertThat(leftItems).containsExactly(left1).inOrder()
            assertThat(rightItems).containsExactly(right1, right2).inOrder()
        }
    }
}
