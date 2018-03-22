package ktfx.styles.scene.layout

import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.layout.GridPane
import ktfx.styles.gridPaneStyle
import ktfx.styles.NodeTest
import kotlin.test.assertEquals

class GridPaneStyleTest : NodeTest<GridPane>() {

    override fun newInstance() = GridPane()

    override val style: String
        get() = gridPaneStyle {
            hgap = 10
            vgap = 20
            alignment = TOP_RIGHT
            // gridLinesVisible = true
        }

    override fun GridPane.assertion() {
        assertEquals(hgap, 10.0)
        assertEquals(vgap, 20.0)
        assertEquals(alignment, TOP_RIGHT)
        // assertEquals(node.isGridLinesVisible, true)
    }
}