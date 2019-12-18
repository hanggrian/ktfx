package ktfx.controls

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.TilePane
import kotlin.test.Test
import kotlin.test.assertEquals
import ktfx.test.ToolkitInitializer

class LayoutTest : ToolkitInitializer {

    @Test fun gap() {
        val flowPane = FlowPane()
        flowPane.gap = 10.0
        assertEquals(10.0, flowPane.hgap)
        assertEquals(10.0, flowPane.vgap)

        val gridPane = GridPane()
        gridPane.gap = 20.0
        assertEquals(20.0, gridPane.hgap)
        assertEquals(20.0, gridPane.vgap)

        val tilePane = TilePane()
        tilePane.gap = 30.0
        assertEquals(30.0, tilePane.hgap)
        assertEquals(30.0, tilePane.vgap)
    }
}
