@file:JvmMultifileClass
@file:JvmName("RegionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.image.Image
import javafx.scene.layout.Border
import javafx.scene.layout.BorderImage
import javafx.scene.layout.BorderRepeat
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Paint

class BorderBuilder internal constructor() {
    private val strokes: MutableList<BorderStroke> = mutableListOf()
    private val images: MutableList<BorderImage> = mutableListOf()

    fun stroke(
        topStroke: Paint? = null,
        rightStroke: Paint? = null,
        bottomStroke: Paint? = null,
        leftStroke: Paint? = null,
        topStyle: BorderStrokeStyle? = null,
        bottomStyle: BorderStrokeStyle? = null,
        leftStyle: BorderStrokeStyle? = null,
        rightStyle: BorderStrokeStyle? = null,
        radii: CornerRadii? = null,
        widths: BorderWidths? = null,
        insets: Insets? = null
    ): BorderStroke = BorderStroke(
        topStroke,
        rightStroke,
        bottomStroke,
        leftStroke,
        topStyle,
        rightStyle,
        bottomStyle,
        leftStyle,
        radii,
        widths,
        insets
    ).also { strokes += it }

    inline fun stroke(
        stroke: Paint? = null,
        style: BorderStrokeStyle? = null,
        radii: CornerRadii? = null,
        widths: BorderWidths? = null,
        insets: Insets? = null
    ): BorderStroke = stroke(stroke, stroke, stroke, stroke, style, style, style, style, radii, widths, insets)

    fun image(
        image: Image,
        widths: BorderWidths? = null,
        insets: Insets? = null,
        slices: BorderWidths? = null,
        filled: Boolean,
        repeatX: BorderRepeat? = null,
        repeatY: BorderRepeat? = null
    ): BorderImage = BorderImage(image, widths, insets, slices, filled, repeatX, repeatY).also { images += it }

    inline fun image(
        image: String,
        widths: BorderWidths? = null,
        insets: Insets? = null,
        slices: BorderWidths? = null,
        filled: Boolean,
        repeatX: BorderRepeat? = null,
        repeatY: BorderRepeat? = null
    ): BorderImage = image(Image(image), widths, insets, slices, filled, repeatX, repeatY)

    fun build(): Border =
        Border(strokes, images)
}

/** Invokes DSL to append [BorderStroke] and [BorderImage] to this [Region]. */
fun Region.border(block: BorderBuilder.() -> Unit): Border =
    BorderBuilder().apply(block).build().also { border = it }

/**
 * Quickly adding border stroke without DSL.
 *
 * @see BorderBuilder.stroke
 */
inline fun Region.borderStroke(
    topStroke: Paint? = null,
    rightStroke: Paint? = null,
    bottomStroke: Paint? = null,
    leftStroke: Paint? = null,
    topStyle: BorderStrokeStyle? = null,
    bottomStyle: BorderStrokeStyle? = null,
    leftStyle: BorderStrokeStyle? = null,
    rightStyle: BorderStrokeStyle? = null,
    radii: CornerRadii? = null,
    widths: BorderWidths? = null,
    insets: Insets? = null
): Border = border {
    stroke(
        topStroke,
        rightStroke,
        bottomStroke,
        leftStroke,
        topStyle,
        bottomStyle,
        leftStyle,
        rightStyle,
        radii,
        widths,
        insets
    )
}

/**
 * Quickly adding border stroke without DSL.
 *
 * @see BorderBuilder.stroke
 */
inline fun Region.borderStroke(
    stroke: Paint? = null,
    style: BorderStrokeStyle? = null,
    radii: CornerRadii? = null,
    widths: BorderWidths? = null,
    insets: Insets? = null
): Border = border { stroke(stroke, style, radii, widths, insets) }

/**
 * Quickly adding border image without DSL.
 *
 * @see BorderBuilder.image
 */
inline fun Region.borderImage(
    image: Image,
    widths: BorderWidths? = null,
    insets: Insets? = null,
    slices: BorderWidths? = null,
    filled: Boolean,
    repeatX: BorderRepeat? = null,
    repeatY: BorderRepeat? = null
): Border = border { image(image, widths, insets, slices, filled, repeatX, repeatY) }

/**
 * Quickly adding border image without DSL.
 *
 * @see BorderBuilder.image
 */
inline fun Region.borderImage(
    image: String,
    widths: BorderWidths? = null,
    insets: Insets? = null,
    slices: BorderWidths? = null,
    filled: Boolean,
    repeatX: BorderRepeat? = null,
    repeatY: BorderRepeat? = null
): Border = border { image(image, widths, insets, slices, filled, repeatX, repeatY) }
