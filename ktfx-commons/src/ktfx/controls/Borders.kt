@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

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
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/**
 * Builds new border with multiple [BorderStroke] and/or [BorderImage].
 * @param builderAction populate newly created stroke and/or image.
 * @return created border.
 */
inline fun buildBorder(
    builderAction: BorderBuilder.() -> Unit
): Border = BorderBuilder().apply(builderAction).build()

/**
 * Sets new border with multiple [BorderStroke] and/or [BorderImage].
 * @param builderAction populate newly created stroke and/or image.
 * @return applied border.
 */
inline fun Region.border(
    noinline builderAction: BorderBuilder.() -> Unit
): Border = buildBorder(builderAction).also { border = it }

/**
 * Sets new border with single [BorderStroke].
 * @param builderAction stroke configurator.
 * @return applied border.
 */
inline fun Region.borderStroke(
    noinline builderAction: BorderBuilder.StrokeBuilder.() -> Unit
): Border = border { stroke(builderAction) }

/**
 * Sets new border with single [BorderImage].
 * @param builderAction image configurator.
 * @return applied border.
 */
inline fun Region.borderImage(
    image: Image,
    noinline builderAction: BorderBuilder.ImageBuilder.() -> Unit
): Border = border { image(image, builderAction) }

/** Border configurator class. */
class BorderBuilder {

    /** Current strokes within this border. */
    val strokes: MutableList<BorderStroke> = mutableListOf()

    /** Current images within this border. */
    val images: MutableList<BorderImage> = mutableListOf()

    /**
     * Append a [BorderStroke].
     * @param builderAction stroke configurator.
     * @return added stroke.
     */
    inline fun stroke(builderAction: StrokeBuilder.() -> Unit): BorderStroke =
        StrokeBuilder().apply(builderAction).build().also { strokes += it }

    /**
     * Append a [BorderImage].
     * @param builderAction image configurator.
     * @return added image.
     */
    inline fun image(image: Image, builderAction: ImageBuilder.() -> Unit): BorderImage =
        ImageBuilder(image).apply(builderAction).build().also { images += it }

    /** Return border based on current configuration. */
    fun build(): Border = Border(strokes, images)

    /** Border stroke configurator class. */
    class StrokeBuilder {
        /** The fill to use on the top. If null, defaults to [javafx.scene.paint.Color.BLACK]. */
        var topStroke: Paint? = null

        /** The fill to use on the right. If null, defaults to the same value as [topStroke]. */
        var rightStroke: Paint? = null

        /** The fill to use on the bottom. If null, defaults to the same value as [bottomStroke]. */
        var bottomStroke: Paint? = null

        /** The fill to use on the left. If null, defaults to the same value as [rightStroke]. */
        var leftStroke: Paint? = null

        /** The stroke to use for all sides. If null, we default to [javafx.scene.paint.Color.BLACK]. */
        var stroke: Paint?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                topStroke = value
                rightStroke = value
                bottomStroke = value
                leftStroke = value
            }

        /** The style to use on the top. If null, defaults to [BorderStrokeStyle.NONE]. */
        var topStyle: BorderStrokeStyle? = null

        /** The style to use on the right. If null, defaults to the same value as [topStyle]. */
        var rightStyle: BorderStrokeStyle? = null

        /** The style to use on the bottom. If null, defaults to the same value as [topStyle]. */
        var bottomStyle: BorderStrokeStyle? = null

        /** The style to use on the left. If null, defaults to the same value as [rightStyle]. */
        var leftStyle: BorderStrokeStyle? = null

        /** The style to use for all sides. If null, we default to [BorderStrokeStyle.NONE]. */
        var style: BorderStrokeStyle?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                topStyle = value
                rightStyle = value
                bottomStyle = value
                leftStyle = value
            }

        /** The radii. If null, we default to square corners by using [CornerRadii.EMPTY]. */
        var radii: CornerRadii? = null

        /** The thickness of each side. If null, we default to [BorderWidths.DEFAULT]. */
        var widths: BorderWidths? = null

        /** The insets indicating where to draw the border relative to the region edges. */
        var insets: Insets? = null

        /** Return border stroke based on current configuration. */
        fun build(): BorderStroke = BorderStroke(
            topStroke, rightStroke, bottomStroke, leftStroke,
            topStyle, rightStyle, bottomStyle, leftStyle,
            radii, widths, insets
        )
    }

    /** Border image configurator class. */
    class ImageBuilder(private val image: Image) {
        /** The widths of the border in each dimension. A null value results in [BorderWidths.EMPTY]. */
        var widths: BorderWidths? = null

        /** The insets at which to place the border relative to the region. A null value results in [Insets.EMPTY]. */
        var insets: Insets? = null

        /** The slices for the image. If null, defaults to [BorderWidths.DEFAULT]. */
        var slices: BorderWidths? = null

        var isFilled: Boolean = false

        /** The repeat value for the border image in the x direction. If null, defaults to [BorderRepeat.STRETCH]. */
        var repeatX: BorderRepeat? = null

        /** The repeat value for the border image in the y direction. If null, defaults to the same value as repeatX. */
        var repeatY: BorderRepeat? = null

        /** The repeat value for the border image in the x and y direction. If null, defaults to [BorderRepeat.STRETCH]. */
        var repeat: BorderRepeat?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                repeatX = value
                repeatY = value
            }

        /** Return border image based on current configuration. */
        fun build(): BorderImage = BorderImage(image, widths, insets, slices, isFilled, repeatX, repeatY)
    }
}
