package ktfx.controls

import com.hendraanggrian.ktfx.test.initToolkit
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DimensionsTest {

    @BeforeTest fun start() = initToolkit()

    @Test fun gap() {
        val flowPane = FlowPane()
        flowPane.gap = 10 to 20
        assertEquals(10.0, flowPane.hgap)
        assertEquals(20.0, flowPane.vgap)

        val gridPane = GridPane()
        gridPane.gap = 10 to 20
        assertEquals(10.0, gridPane.hgap)
        assertEquals(20.0, gridPane.vgap)

        val tilePane = TilePane()
        tilePane.gap = 10 to 20
        assertEquals(10.0, tilePane.hgap)
        assertEquals(20.0, tilePane.vgap)
    }

    @Test fun minSize() {
        val region = Region()
        region.minSize = 10 to 20
        assertEquals(10.0, region.minWidth)
        assertEquals(20.0, region.minHeight)
    }

    @Test fun prefSize() {
        val region = Region()
        region.prefSize = 10 to 20
        assertEquals(10.0, region.prefWidth)
        assertEquals(20.0, region.prefHeight)
    }

    @Test fun maxSize() {
        val region = Region()
        region.maxSize = 10 to 20
        assertEquals(10.0, region.maxWidth)
        assertEquals(20.0, region.maxHeight)
    }

    @Test fun padding() {
        val region = Region()
        region padding 10
        assertEquals(10.0, region.padding.top)
        assertEquals(10.0, region.padding.right)
        assertEquals(10.0, region.padding.bottom)
        assertEquals(10.0, region.padding.left)
        region.padding(top = 15)
        assertEquals(15.0, region.padding.top)
        region.padding(left = 20)
        assertEquals(20.0, region.padding.left)
        region.padding(right = 25)
        assertEquals(25.0, region.padding.right)
        region.padding(bottom = 30)
        assertEquals(30.0, region.padding.bottom)
        region.padding(horizontal = 35)
        assertEquals(35.0, region.padding.left)
        assertEquals(35.0, region.padding.right)
        region.padding(vertical = 40)
        assertEquals(40.0, region.padding.top)
        assertEquals(40.0, region.padding.bottom)
    }
}
