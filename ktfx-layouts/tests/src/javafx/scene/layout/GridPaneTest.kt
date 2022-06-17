package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.GridPane
import ktfx.controls.H_RIGHT
import ktfx.controls.V_BOTTOM
import kotlin.test.Test
import kotlin.test.assertEquals

class GridPaneTest : LayoutsTest<KtfxPane, GridPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = gridPane { }
    override fun KtfxPane.child2() = gridPane()
    override fun KtfxPane.child3() = gridPane { }

    @Test
    fun grid() {
        gridPane {
            val label1 = label().grid(1, 2)
            assertEquals(1, label1.rowIndex)
            assertEquals(2, label1.columnIndex)
            val label2 = label().grid(1 to 3)
            assertEquals(1, label2.rowIndex)
            assertEquals(3, label2.rowSpan)
            val label3 = label().grid(col = 2 to 4)
            assertEquals(2, label3.columnIndex)
            assertEquals(4, label3.columnSpan)
            val label4 = label().grid(1 to 3, 2 to 4)
            assertEquals(1, label4.rowIndex)
            assertEquals(2, label4.columnIndex)
            assertEquals(3, label4.rowSpan)
            assertEquals(4, label4.columnSpan)
        }
    }

    @Test
    fun halign() {
        gridPane {
            val label = label().halign(H_RIGHT)
            assertEquals(H_RIGHT, label.halignment)
        }
    }

    @Test
    fun valign() {
        gridPane {
            val label = label().valign(V_BOTTOM)
            assertEquals(V_BOTTOM, label.valignment)
        }
    }
}
