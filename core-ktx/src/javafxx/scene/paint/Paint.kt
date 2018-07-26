@file:Suppress("NOTHING_TO_INLINE")

package javafxx.scene.paint

import javafx.geometry.Insets
import javafx.scene.effect.ColorInput
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Paint

/** Creates a new instance of [ColorInput] with the specified x, y, width, height, and paint. */
inline fun Paint.toInput(
    x: Double,
    y: Double,
    width: Double,
    height: Double
): ColorInput = ColorInput(x, y, width, height, this)

/** Creates a new [BackgroundFill] with the specified fill, radii, and insets. */
inline fun Paint.toBackgroundFill(
    radii: CornerRadii = CornerRadii.EMPTY,
    insets: Insets = Insets.EMPTY
): BackgroundFill = BackgroundFill(this, radii, insets)

/** Creates a new [BorderStroke]. */
inline fun Paint.toBorderStroke(
    style: BorderStrokeStyle,
    radii: CornerRadii,
    widths: BorderWidths
): BorderStroke = BorderStroke(this, style, radii, widths)