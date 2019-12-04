package ktfx.controls

import javafx.scene.layout.Region
import javafx.scene.paint.Color
import ktfx.test.ToolkitInitializer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RegionTest : ToolkitInitializer {

    @Test fun padding() {
        val region = Region()
        region.updatePadding(bottom = 20.0, top = 20.0)
        assertEquals(20.0, region.paddingTop)
        assertEquals(0.0, region.paddingLeft)
        assertEquals(0.0, region.paddingRight)
        assertEquals(20.0, region.paddingBottom)
        region.paddingAll = 10.0
        assertEquals(10.0, region.paddingTop)
        assertEquals(10.0, region.paddingLeft)
        assertEquals(10.0, region.paddingRight)
        assertEquals(10.0, region.paddingBottom)
        region.paddingTop = 15.0
        assertEquals(15.0, region.paddingTop)
        region.paddingLeft = 20.0
        assertEquals(20.0, region.paddingLeft)
        region.paddingRight = 25.0
        assertEquals(25.0, region.paddingRight)
        region.paddingBottom = 30.0
        assertEquals(30.0, region.paddingBottom)
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