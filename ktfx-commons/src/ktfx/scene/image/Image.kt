@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.image

import javafx.scene.ImageCursor
import javafx.scene.effect.ImageInput
import javafx.scene.image.Image
import javafx.scene.layout.BackgroundImage
import javafx.scene.layout.BackgroundPosition
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.BorderImage
import javafx.scene.layout.BorderRepeat
import javafx.scene.layout.BorderWidths
import javafx.scene.paint.ImagePattern
import ktfx.geometry.Padding

/** Constructs an [ImageCursor] from the specified image and hotspot coordinates. */
inline fun Image.toCursor(
    hotspotX: Double = 0.0,
    hotspotY: Double = 0.0
): ImageCursor = ImageCursor(this, hotspotX, hotspotY)

/** Creates a new instance of [ImageInput] with the specified source, x and y. */
inline fun Image.toInput(
    x: Double = 0.0,
    y: Double = 0.0
): ImageInput = ImageInput(this, x, y)

/** Creates a new [BackgroundImage]. */
inline fun Image.toBackground(
    repeatX: BackgroundRepeat,
    repeatY: BackgroundRepeat,
    position: BackgroundPosition,
    size: BackgroundSize
): BackgroundImage = BackgroundImage(this, repeatX, repeatY, position, size)

/** Creates a new [BorderImage]. */
inline fun Image.toBorder(
    widths: BorderWidths,
    padding: Padding,
    slices: BorderWidths,
    filled: Boolean,
    repeatX: BorderRepeat,
    repeatY: BorderRepeat
): BorderImage = BorderImage(this, widths, padding, slices, filled, repeatX, repeatY)

/** Creates a new instance of [ImagePattern]. */
inline fun Image.toPattern(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 1.0,
    height: Double = 1.0,
    proportional: Boolean = true
): ImagePattern = ImagePattern(this, x, y, width, height, proportional)