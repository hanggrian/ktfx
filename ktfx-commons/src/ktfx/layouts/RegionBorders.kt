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

/**
 * Class to support adding backgrounds to node with Kotlin DSL.
 *
 * @see Region.border
 */
class BorderBuilder internal constructor() {
    private val strokes: MutableList<BorderStroke> = mutableListOf()
    private val images: MutableList<BorderImage> = mutableListOf()

    /**
     * Add a new [BorderStroke] to node, specifying all construction parameters.
     *
     * @param topStroke the fill to use on the top. If null, defaults to BLACK.
     * @param rightStroke the fill to use on the right. If null, defaults to the same value as topStroke
     * @param bottomStroke the fill to use on the bottom. If null, defaults to the same value as bottomStroke
     * @param leftStroke the fill to use on the left. If null, defaults to the same value as rightStroke
     * @param topStyle the style to use on the top. If null, defaults to BorderStrokeStyle.NONE
     * @param rightStyle the style to use on the right. If null, defaults to the same value as topStyle
     * @param bottomStyle the style to use on the bottom. If null, defaults to the same value as topStyle
     * @param leftStyle the style to use on the left. If null, defaults to the same value as rightStyle
     * @param radii the radii. If null, we default to square corners by using CornerRadii.EMPTY
     * @param widths the thickness of each side. If null, we default to DEFAULT_WIDTHS.
     * @param insets the insets indicating where to draw the border relative to the region edges.
     */
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
        topStroke, rightStroke, bottomStroke, leftStroke,
        topStyle, rightStyle, bottomStyle, leftStyle,
        radii, widths, insets
    ).also { strokes += it }

    /**
     * Add a new [BorderStroke] to node.
     *
     * @param stroke the stroke to use for all sides. If null, we default to Color.BLACK.
     * @param style the style to use for all sides. If null, we default to BorderStrokeStyle.NONE
     * @param radii the radii to use. If null, we default to CornerRadii.EMPTY
     * @param widths the widths to use. If null, we default to DEFAULT_WIDTHS
     */
    inline fun stroke(
        stroke: Paint? = null,
        style: BorderStrokeStyle? = null,
        radii: CornerRadii? = null,
        widths: BorderWidths? = null,
        insets: Insets? = null
    ): BorderStroke = stroke(stroke, stroke, stroke, stroke, style, style, style, style, radii, widths, insets)

    /**
     * Add a new [BorderImage] to node.
     * The image must be specified or a NullPointerException will be thrown.
     *
     * @param image the image to use. This must not be null.
     * @param widths the widths of the border in each dimension. A null value results in Insets.EMPTY.
     * @param insets the insets at which to place the border relative to the region. A null value results in Insets.EMPTY.
     * @param slices the slices for the image. If null, defaults to BorderImageSlices.DEFAULT
     * @param repeatX the repeat value for the border image in the x direction. If null, defaults to STRETCH.
     * @param repeatY the repeat value for the border image in the y direction. If null, defaults to the same value as repeatX.
     */
    fun image(
        image: Image,
        widths: BorderWidths? = null,
        insets: Insets? = null,
        slices: BorderWidths? = null,
        filled: Boolean,
        repeatX: BorderRepeat? = null,
        repeatY: BorderRepeat? = null
    ): BorderImage = BorderImage(image, widths, insets, slices, filled, repeatX, repeatY).also { images += it }

    /**
     * Add a new [BorderImage] to node using string url.
     * The image must be specified or a NullPointerException will be thrown.
     *
     * @param image the image to use. This must not be null.
     * @param widths the widths of the border in each dimension. A null value results in Insets.EMPTY.
     * @param insets the insets at which to place the border relative to the region. A null value results in Insets.EMPTY.
     * @param slices the slices for the image. If null, defaults to BorderImageSlices.DEFAULT
     * @param repeatX the repeat value for the border image in the x direction. If null, defaults to STRETCH.
     * @param repeatY the repeat value for the border image in the y direction. If null, defaults to the same value as repeatX.
     */
    inline fun image(
        image: String,
        widths: BorderWidths? = null,
        insets: Insets? = null,
        slices: BorderWidths? = null,
        filled: Boolean,
        repeatX: BorderRepeat? = null,
        repeatY: BorderRepeat? = null
    ): BorderImage = image(Image(image), widths, insets, slices, filled, repeatX, repeatY)

    internal fun build(): Border =
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
        topStroke, rightStroke, bottomStroke, leftStroke,
        topStyle, bottomStyle, leftStyle, rightStyle,
        radii, widths, insets
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
