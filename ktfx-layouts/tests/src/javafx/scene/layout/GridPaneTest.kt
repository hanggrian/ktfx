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

    @Test fun grid() {
        gridPane {
            val label = label().grid(row = 1, rowSpan = 3, col = 2, colSpan = 4)
            assertEquals(1, label.rowIndex)
            assertEquals(2, label.columnIndex)
            assertEquals(3, label.rowSpan)
            assertEquals(4, label.columnSpan)
        }
    }

    @Test fun halign() {
        gridPane {
            val label = label().halign(H_RIGHT)
            assertEquals(H_RIGHT, label.halignment)
        }
    }

    @Test fun valign() {
        gridPane {
            val label = label().valign(V_BOTTOM)
            assertEquals(V_BOTTOM, label.valignment)
        }
    }
}