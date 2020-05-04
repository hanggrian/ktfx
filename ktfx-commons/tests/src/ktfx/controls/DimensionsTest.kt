package ktfx.controls

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DimensionsTest {

    @BeforeTest fun start() = initToolkit()

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

    @Test fun padding() {
        val region = Region()
        region.paddings = 10.0
        assertEquals(10.0, region.topPadding)
        assertEquals(10.0, region.leftPadding)
        assertEquals(10.0, region.rightPadding)
        assertEquals(10.0, region.bottomPadding)
        region.topPadding = 15.0
        assertEquals(15.0, region.topPadding)
        region.leftPadding = 20.0
        assertEquals(20.0, region.leftPadding)
        region.rightPadding = 25.0
        assertEquals(25.0, region.rightPadding)
        region.bottomPadding = 30.0
        assertEquals(30.0, region.bottomPadding)
        region.horizontalPadding = 35.0
        assertEquals(35.0, region.leftPadding)
        assertEquals(35.0, region.rightPadding)
        region.verticalPadding = 40.0
        assertEquals(40.0, region.topPadding)
        assertEquals(40.0, region.bottomPadding)
    }
}
