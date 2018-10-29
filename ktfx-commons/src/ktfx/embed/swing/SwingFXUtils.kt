@file:Suppress("NOTHING_TO_INLINE")

package ktfx.embed.swing

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import javafx.scene.image.WritableImage
import java.awt.image.BufferedImage

/**
 * Snapshots the specified [BufferedImage] and stores a copy of its pixels into a JavaFX [Image] object,
 * creating a new object if needed.
 */
inline fun BufferedImage.toFxImage(wimg: WritableImage? = null): WritableImage =
    SwingFXUtils.toFXImage(this, wimg)

/**
 * Snapshots the specified JavaFX [Image] object and stores a copy of its pixels into a [BufferedImage] object,
 * creating a new object if needed.
 */
inline fun Image.toSwingImage(bimg: BufferedImage? = null): BufferedImage = SwingFXUtils.fromFXImage(this, bimg)