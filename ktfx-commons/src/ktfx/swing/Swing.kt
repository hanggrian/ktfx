package ktfx.swing

import java.awt.image.BufferedImage
import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import javafx.scene.image.WritableImage

/**
 * Snapshots the specified [BufferedImage] and stores a copy of its pixels into a JavaFX [Image] object,
 * creating a new object if needed.
 */
fun BufferedImage.toFxImage(wimg: WritableImage? = null): WritableImage =
    SwingFXUtils.toFXImage(this, wimg)

/**
 * Snapshots the specified JavaFX [Image] object and stores a copy of its pixels into a [BufferedImage] object,
 * creating a new object if needed.
 */
fun Image.toSwingImage(bimg: BufferedImage? = null): BufferedImage =
    SwingFXUtils.fromFXImage(this, bimg)
