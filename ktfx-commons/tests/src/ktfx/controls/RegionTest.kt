package ktfx.controls

import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RegionTest {

    @BeforeTest fun start() = initToolkit()

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

    @Test fun background() {
        val region = Region()
        assertNull(region.background)
        region.backgroundFill {
            fill = Color.RED
            radii = CornerRadii(5.0)
        }
        val fill = region.background.fills.first()
        assertEquals(Color.RED, fill.fill)
        assertEquals(5.0, fill.radii.bottomLeftHorizontalRadius)
    }

    @Test fun border() {
        val region = Region()
        assertNull(region.border)
        region.borderStroke {
            stroke = Color.RED
            widths = BorderWidths.FULL
        }
        val stroke = region.border.strokes.first()
        assertEquals(Color.RED, stroke.topStroke)
        assertEquals(BorderWidths.FULL, stroke.widths)
    }
}
