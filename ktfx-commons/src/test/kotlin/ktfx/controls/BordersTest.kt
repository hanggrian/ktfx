package ktfx.controls

import com.hanggrian.ktfx.test.SampleImage
import com.hanggrian.ktfx.test.initToolkit
import javafx.geometry.Insets
import javafx.scene.layout.BorderRepeat
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BordersTest {
    private lateinit var region: Region

    @BeforeTest
    fun start() {
        initToolkit()
        region = Region()
    }

    @Test
    fun border() {
        region.border {
            stroke {}
            image(SampleImage()) {}
        }
        assertEquals(1, region.border.strokes.size)
        assertEquals(1, region.border.images.size)
    }

    @Test
    fun strokeBorder() {
        region.strokeBorder {
            stroke = Color.RED
            style = BorderStrokeStyle.DOTTED
            radii = CornerRadii(5.0)
            widths = BorderWidths.FULL
            insets = Insets(10.0)
        }
        region.border.strokes.first().let {
            assertEquals(Color.RED, it.topStroke)
            assertEquals(Color.RED, it.leftStroke)
            assertEquals(Color.RED, it.rightStroke)
            assertEquals(Color.RED, it.bottomStroke)
            assertEquals(BorderStrokeStyle.DOTTED, it.topStyle)
            assertEquals(BorderStrokeStyle.DOTTED, it.leftStyle)
            assertEquals(BorderStrokeStyle.DOTTED, it.rightStyle)
            assertEquals(BorderStrokeStyle.DOTTED, it.bottomStyle)
            assertEquals(CornerRadii(5.0), it.radii)
            assertEquals(BorderWidths.FULL, it.widths)
            assertEquals(Insets(10.0), it.insets)
        }
    }

    @Test
    fun imageBorder() {
        val sample = SampleImage()
        region.imageBorder(sample) {
            widths = BorderWidths.FULL
            insets = Insets(10.0)
            slices = BorderWidths.FULL
            isFilled = true
            repeat = BorderRepeat.ROUND
        }
        region.border.images.first().let {
            assertEquals(sample, it.image)
            assertEquals(BorderWidths.FULL, it.widths)
            assertEquals(Insets(10.0), it.insets)
            assertEquals(BorderWidths.FULL, it.slices)
            assertTrue(it.isFilled)
            assertEquals(BorderRepeat.ROUND, it.repeatX)
            assertEquals(BorderRepeat.ROUND, it.repeatY)
        }
    }
}
