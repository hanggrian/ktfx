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

class BackgroundsTest {

    @BeforeTest fun start() = initToolkit()


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
