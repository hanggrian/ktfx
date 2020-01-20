package ktfx.controls

import javafx.scene.layout.Region
import javafx.scene.paint.Color
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RegionTest {

    @BeforeTest fun start() = initToolkit()

    @Test fun padding() {
        val region = Region()
        region.allPadding = 10.0
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
        region.backgroundFill(Color.RED)
        assertEquals(Color.RED, region.background.fills.first().fill)
    }

    @Test fun border() {
        val region = Region()
        assertNull(region.border)
        region.borderStroke(Color.RED)
        assertEquals(Color.RED, region.border.strokes.first().topStroke)
        assertTrue(region.border.strokes.first().isStrokeUniform)
    }
}
