package ktfx.layouts.scene.layout

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.columnConstraints
import ktfx.layouts.gridPane
import ktfx.layouts.label
import ktfx.layouts.rowConstraints
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GridPaneTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        gridPane {
            rowConstraints {
                constraints {
                    isFillHeight = true
                }
            }
            columnConstraints {
                constraints(72.0)
            }
            label {
                constraints row 1 col 2 rowSpan 3 colSpan 4
                assertEquals(1, constraints.rowIndex)
                assertEquals(2, constraints.columnIndex)
                assertEquals(3, constraints.rowSpan)
                assertEquals(4, constraints.columnSpan)
            }
            assertTrue(rowConstraints.first().isFillHeight)
            assertEquals(72.0, columnConstraints.first().prefWidth)
        }
    }
}