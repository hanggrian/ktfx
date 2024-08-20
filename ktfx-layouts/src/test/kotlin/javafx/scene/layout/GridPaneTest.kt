package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import ktfx.controls.H_LEFT
import ktfx.controls.H_RIGHT
import ktfx.controls.V_BOTTOM
import ktfx.controls.V_TOP
import ktfx.controls.insetsOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class GridPaneTest : LayoutsStyledTest<KtfxPane, GridPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = gridPane {}

    override fun KtfxPane.child2() = gridPane()

    override fun child3() = styledGridPane()

    override fun KtfxPane.child4() = styledGridPane()

    @Test
    fun grid() {
        gridPane {
            val region = region()

            region.grid(row = 1)
            assertEquals(1, region.rowIndex)
            region.grid(col = 2)
            assertEquals(2, region.columnIndex)
            region.clearConstraints()

            region.grid(1 to 3)
            assertEquals(1, region.rowIndex)
            assertEquals(3, region.rowSpan)
            region.clearConstraints()

            region.grid(col = 2 to 4)
            assertEquals(2, region.columnIndex)
            assertEquals(4, region.columnSpan)
            region.clearConstraints()

            region.grid(1 to 3, 2 to 4)
            assertEquals(1, region.rowIndex)
            assertEquals(2, region.columnIndex)
            assertEquals(3, region.rowSpan)
            assertEquals(4, region.columnSpan)
            region.clearConstraints()

            assertNull(region.rowIndex)
            assertNull(region.columnIndex)
            assertNull(region.rowSpan)
            assertNull(region.columnSpan)
        }
    }

    @Test
    fun halign() {
        gridPane {
            val region = region()

            region.halign(H_LEFT)
            assertEquals(H_LEFT, region.halignment)
            region.clearConstraints()

            region.halignment = H_RIGHT
            assertEquals(H_RIGHT, region.halignment)
            region.clearConstraints()

            assertNull(region.halignment)
        }
    }

    @Test
    fun valign() {
        gridPane {
            val region = region()

            region.valign(V_TOP)
            assertEquals(V_TOP, region.valignment)
            region.clearConstraints()

            region.valignment = V_BOTTOM
            assertEquals(V_BOTTOM, region.valignment)
            region.clearConstraints()

            assertNull(region.valignment)
        }
    }

    @Test
    fun fillWidth() {
        gridPane {
            val region = region()

            region.fillWidth()
            assertTrue(region.isFillWidth!!)
            region.clearConstraints()

            region.isFillWidth = false
            assertFalse(region.isFillWidth!!)
            region.clearConstraints()
        }
    }

    @Test
    fun fillHeight() {
        gridPane {
            val region = region()

            region.fillHeight()
            assertTrue(region.isFillHeight!!)
            region.clearConstraints()

            region.isFillHeight = false
            assertFalse(region.isFillHeight!!)
            region.clearConstraints()
        }
    }

    @Test
    fun hgrow() {
        gridPane {
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

    @Test
    fun vgrow() {
        gridPane {
            val region = region()

            region.vgrow()
            assertEquals(Priority.ALWAYS, region.vgrow)
            region.clearConstraints()

            region.vgrow(false)
            assertEquals(Priority.NEVER, region.vgrow)
            region.clearConstraints()

            region.vgrow = Priority.SOMETIMES
            assertEquals(Priority.SOMETIMES, region.vgrow)
            region.clearConstraints()

            assertNull(region.vgrow)
        }
    }

    @Test
    fun margin() {
        gridPane {
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
