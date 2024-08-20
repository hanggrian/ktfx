package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import ktfx.controls.insetsOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BorderPaneTest : LayoutsStyledTest<KtfxPane, BorderPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = borderPane {}

    override fun KtfxPane.child2() = borderPane()

    override fun child3() = styledBorderPane()

    override fun KtfxPane.child4() = styledBorderPane()

    @Test
    fun align() {
        borderPane {
            val region = region()

            region.align(Pos.CENTER_LEFT)
            assertEquals(Pos.CENTER_LEFT, region.alignment)
            region.clearConstraints()

            region.alignment = Pos.CENTER_RIGHT
            assertEquals(Pos.CENTER_RIGHT, region.alignment)
            region.clearConstraints()

            assertNull(region.alignment)
        }
    }

    @Test
    fun margin() {
        borderPane {
            val region = region()

            region.margin(insetsOf(1.0))
            assertEquals(1.0, region.margin!!.top)
            assertEquals(1.0, region.margin!!.right)
            assertEquals(1.0, region.margin!!.bottom)
            assertEquals(1.0, region.margin!!.left)
            region.clearConstraints()

            region.margin = insetsOf(2.0)
            assertEquals(2.0, region.margin!!.top)
            assertEquals(2.0, region.margin!!.right)
            assertEquals(2.0, region.margin!!.bottom)
            assertEquals(2.0, region.margin!!.left)
            region.clearConstraints()

            assertNull(region.margin)
        }
    }
}
