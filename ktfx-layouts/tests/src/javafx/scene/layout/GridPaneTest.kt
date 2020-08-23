package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.GridPane
import kotlin.test.Test
import kotlin.test.assertEquals

class GridPaneTest : LayoutsTest<KtfxPane, GridPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = gridPane { }
    override fun KtfxPane.child2() = gridPane()
    override fun KtfxPane.child3() = gridPane { }

    @Test fun colAndRow() {
        gridPane {
            val label = label().grid(row = 1, rowSpan = 3, col = 2, colSpan = 4)
            assertEquals(1, label.rowIndex)
            assertEquals(2, label.columnIndex)
            assertEquals(3, label.rowSpan)
            assertEquals(4, label.columnSpan)
        }
    }
}