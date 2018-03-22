package ktfx.styles.scene.layout

import javafx.geometry.HPos.CENTER
import javafx.geometry.Orientation.VERTICAL
import javafx.geometry.Pos.TOP_RIGHT
import javafx.geometry.VPos.BOTTOM
import javafx.scene.layout.FlowPane
import ktfx.styles.flowPaneStyle
import ktfx.styles.NodeTest
import kotlin.test.assertEquals

class FlowPaneStyleTest : NodeTest<FlowPane>() {

    override fun newInstance() = FlowPane()

    override val style: String
        get() = flowPaneStyle {
            hgap = 10
            vgap = 20
            alignment = TOP_RIGHT
            columnHalignment = CENTER
            rowValignment = BOTTOM
            orientation = VERTICAL
        }

    override fun FlowPane.assertion() {
        assertEquals(hgap, 10.0)
        assertEquals(vgap, 20.0)
        assertEquals(alignment, TOP_RIGHT)
        assertEquals(columnHalignment, CENTER)
        assertEquals(rowValignment, BOTTOM)
        assertEquals(orientation, VERTICAL)
    }
}