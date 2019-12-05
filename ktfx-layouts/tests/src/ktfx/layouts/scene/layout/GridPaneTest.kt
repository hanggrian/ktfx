package ktfx.layouts.scene.layout

import javafx.scene.layout.GridPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.columnConstraints
import ktfx.layouts.gridPane
import ktfx.layouts.label
import ktfx.layouts.rowConstraints
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GridPaneTest : LayoutTest<NodeManager, GridPane>() {

    override fun createManager() = KtfxPane()
    override fun create() = gridPane { }
    override fun NodeManager.add() = gridPane()
    override fun NodeManager.addWithBuilder() = gridPane { }

    @Test fun constraints() {
        gridPane {
            rowConstraints {
                constraints {
                    isFillHeight = true
                }
            }
            columnConstraints {
                constraints(72.0)
            }
            assertTrue(rowConstraints.first().isFillHeight)
            assertEquals(72.0, columnConstraints.first().prefWidth)
        }
    }

    @Test fun colAndRow() {
        gridPane {
            val label = label() row (1 to 3) col (2 to 4)
            assertEquals(1, label.rowIndex)
            assertEquals(2, label.columnIndex)
            assertEquals(3, label.rowSpan)
            assertEquals(4, label.columnSpan)
        }
    }
}