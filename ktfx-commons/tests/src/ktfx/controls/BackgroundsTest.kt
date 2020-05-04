package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.BackgroundPosition
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import com.hendraanggrian.ktfx.test.SampleImage
import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BackgroundsTest {
    private lateinit var region: Region

    @BeforeTest fun start() {
        initToolkit()
        region = Region()
    }

    @Test fun multiple() {
        region.background {
            fill { }
            image(SampleImage()) { }
        }
        assertEquals(1, region.background.fills.size)
        assertEquals(1, region.background.images.size)
    }

    @Test fun singleFill() {
        region.backgroundFill {
            fill = Color.RED
            radii = CornerRadii(5.0)
            insets = Insets(10.0)
        }
        val fill = region.background.fills.first()
        assertEquals(Color.RED, fill.fill)
        assertEquals(5.0, fill.radii.bottomLeftHorizontalRadius)
        assertEquals(Insets(10.0), fill.insets)
    }

    @Test fun singleImage() {
        val sample = SampleImage()
        val backgroundSize = BackgroundSize(1.0, 2.0, true, true, true, true)
        region.backgroundImage(sample) {
            repeat = BackgroundRepeat.ROUND
            position = BackgroundPosition.CENTER
            size = backgroundSize
        }
        region.background.images.first().let {
            assertEquals(sample, it.image)
            assertEquals(BackgroundRepeat.ROUND, it.repeatX)
            assertEquals(BackgroundRepeat.ROUND, it.repeatY)
            assertEquals(BackgroundPosition.CENTER, it.position)
            assertEquals(backgroundSize, it.size)
        }
    }
}
