package ktfx.controls

import com.hanggrian.ktfx.test.SampleImage
import com.hanggrian.ktfx.test.initToolkit
import javafx.geometry.Insets
import javafx.scene.layout.BackgroundPosition
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BackgroundsTest {
    private lateinit var region: Region

    @BeforeTest
    fun start() {
        initToolkit()
        region = Region()
    }

    @Test
    fun multiple() {
        region.background {
            fill {}
            image(SampleImage()) {}
        }
        assertEquals(1, region.background.fills.size)
        assertEquals(1, region.background.images.size)
    }

    @Test
    fun singleFill() {
        region.fillBackground {
            fill = Color.RED
            radii = CornerRadii(5.0)
            insets = Insets(10.0)
        }
        val fill = region.background.fills.single()
        assertEquals(Color.RED, fill.fill)
        assertEquals(5.0, fill.radii.bottomLeftHorizontalRadius)
        assertEquals(Insets(10.0), fill.insets)
    }

    @Test
    fun singleImage() {
        val sample = SampleImage()
        val backgroundSize = BackgroundSize(1.0, 2.0, true, true, true, true)
        region.imageBackground(sample) {
            repeatX = BackgroundRepeat.REPEAT
            repeatY = BackgroundRepeat.SPACE
            position = BackgroundPosition.CENTER
            size = backgroundSize
        }
        region.background.images.single().let {
            assertEquals(sample, it.image)
            assertEquals(BackgroundRepeat.REPEAT, it.repeatX)
            assertEquals(BackgroundRepeat.SPACE, it.repeatY)
            assertEquals(BackgroundPosition.CENTER, it.position)
            assertEquals(backgroundSize, it.size)
        }

        region.imageBackground(sample) {
            repeat = BackgroundRepeat.ROUND
        }
        region.background.images.single().let {
            assertEquals(BackgroundRepeat.ROUND, it.repeatX)
            assertEquals(BackgroundRepeat.ROUND, it.repeatY)
        }
    }
}
