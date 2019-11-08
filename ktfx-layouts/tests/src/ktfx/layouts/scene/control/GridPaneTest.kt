package ktfx.layouts.scene.control

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
                rowSpans = 1
            }
            assertTrue(rowConstraints.first().isFillHeight)
            assertEquals(72.0, columnConstraints.first().prefWidth)
        }
    }
}