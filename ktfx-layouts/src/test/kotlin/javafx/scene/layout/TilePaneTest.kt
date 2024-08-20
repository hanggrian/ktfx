package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import ktfx.controls.LEFT
import ktfx.controls.RIGHT
import ktfx.controls.insetsOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TilePaneTest : LayoutsStyledTest<KtfxPane, TilePane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = tilePane {}

    override fun KtfxPane.child2() = tilePane()

    override fun child3() = styledTilePane()

    override fun KtfxPane.child4() = styledTilePane()

    override fun TilePane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }

    @Test
    fun align() {
        tilePane {
            val region = region()

            region.align(LEFT)
            assertEquals(LEFT, region.alignment)
            region.clearConstraints()

            region.alignment = RIGHT
            assertEquals(RIGHT, region.alignment)
            region.clearConstraints()

            assertNull(region.alignment)
        }
    }

    @Test
    fun margin() {
        tilePane {
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
