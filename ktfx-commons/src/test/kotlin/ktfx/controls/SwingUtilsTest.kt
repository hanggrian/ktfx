package ktfx.controls

import javafx.scene.image.WritableImage
import java.awt.image.BufferedImage
import kotlin.test.Test
import kotlin.test.assertEquals

class SwingUtilsTest {
    private companion object {
        const val WIDTH: Int = 1000
        const val HEIGHT: Int = 500
    }

    @Test
    fun toFxImage() {
        val image = BufferedImage(
            WIDTH,
            HEIGHT,
            BufferedImage.TYPE_INT_ARGB,
        ).toFxImage()
        assertEquals(WIDTH, image.width.toInt())
        assertEquals(HEIGHT, image.height.toInt())
    }

    @Test
    fun toSwingImage() {
        val image = WritableImage(
            WIDTH,
            HEIGHT,
        ).toSwingImage()
        assertEquals(WIDTH, image.width)
        assertEquals(HEIGHT, image.height)
    }
}
