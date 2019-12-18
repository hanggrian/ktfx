package ktfx.util

import java.awt.image.BufferedImage
import javafx.scene.image.WritableImage
import kotlin.test.Test
import kotlin.test.assertEquals

class SwingUtilsTest {
    private val width: Int = 1000
    private val height: Int = 500

    @Test fun toFxImage() {
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB).toFxImage()
        assertEquals(width, image.width.toInt())
        assertEquals(height, image.height.toInt())
    }

    @Test fun toSwingImage() {
        val image = WritableImage(width, height).toSwingImage()
        assertEquals(width, image.width)
        assertEquals(height, image.height)
    }
}
