package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXToolbar
import javafx.geometry.Insets
import javafx.scene.layout.Priority
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class JfxToolbarTest : LayoutsStyledTest<KtfxPane, JFXToolbar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxToolbar {}

    override fun KtfxPane.child2() = jfxToolbar()

    override fun child3() = styledJfxToolbar()

    override fun KtfxPane.child4() = styledJfxToolbar()

    @Test
    fun leftAndRightItems() {
        jfxToolbar {
            val left1: JFXButton
            val right1: JFXButton
            val right2: JFXButton
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

    @Test
    fun hgrow() {
        jfxToolbar {
            leftItems {
                val region = region()

                region.hgrow()
                assertEquals(Priority.ALWAYS, region.hgrow)
                region.clearConstraints()

                region.hgrow(false)
                assertEquals(Priority.NEVER, region.hgrow)
                region.clearConstraints()

                region.hgrow = Priority.SOMETIMES
                assertEquals(Priority.SOMETIMES, region.hgrow)
                region.clearConstraints()

                assertNull(region.hgrow)
            }
        }
    }

    @Test
    fun margin() {
        jfxToolbar {
            leftItems {
                val region = region()

                region.margin(Insets(1.0))
                assertEquals(1.0, region.margin!!.top)
                assertEquals(1.0, region.margin!!.right)
                assertEquals(1.0, region.margin!!.bottom)
                assertEquals(1.0, region.margin!!.left)
                region.clearConstraints()

                region.margin = Insets(2.0)
                assertEquals(2.0, region.margin!!.top)
                assertEquals(2.0, region.margin!!.right)
                assertEquals(2.0, region.margin!!.bottom)
                assertEquals(2.0, region.margin!!.left)
                region.clearConstraints()

                assertNull(region.margin)
            }
        }
    }
}
