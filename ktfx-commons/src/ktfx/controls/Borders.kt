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

/** Create multiple [BorderStroke] and/or [BorderImage] using DSL. */
fun buildBorder(builderAction: BorderBuilder.() -> Unit): Border =
    BorderBuilder().apply(builderAction).build()

/** Add multiple [BorderStroke] and/or [BorderImage] to node using DSL. */
inline fun Region.border(noinline builderAction: BorderBuilder.() -> Unit): Border {
    val border = buildBorder(builderAction)
    setBorder(border)
    return border
}

/** Add a new [BorderStroke] to node using DSL. */
inline fun Region.borderStroke(noinline builderAction: BorderBuilder.StrokeBuilder.() -> Unit): Border =
    border { stroke(builderAction) }

/** Add a new [BorderImage] to node using DSL. */
inline fun Region.borderImage(image: Image, noinline builderAction: BorderBuilder.ImageBuilder.() -> Unit): Border =
    border { image(image, builderAction) }

/**
 * Class to support adding [Border] to node with DSL.
 * @see Region.border
 */
class BorderBuilder internal constructor() {
    val strokes: MutableList<BorderStroke> = mutableListOf()
    val images: MutableList<BorderImage> = mutableListOf()

    /** Add a new [BorderStroke] to node using DSL. */
    fun stroke(builderAction: StrokeBuilder.() -> Unit): BorderStroke {
        val borderStroke = StrokeBuilder().apply(builderAction).build()
        strokes += borderStroke
        return borderStroke
    }

    /** Add a new [BorderImage] to node using DSL. */
    fun image(image: Image, builderAction: ImageBuilder.() -> Unit): BorderImage {
        val borderImage = ImageBuilder(image).apply(builderAction).build()
        images += borderImage
        return borderImage
    }

    internal fun build(): Border = Border(strokes, images)

    /**
     * Class to support adding [BorderStroke] stroke to node with DSL.
     * @see BorderBuilder.stroke
     */
    class StrokeBuilder internal constructor() {
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

        internal fun build(): BorderStroke = BorderStroke(
            topStroke, rightStroke, bottomStroke, leftStroke,
            topStyle, rightStyle, bottomStyle, leftStyle,
            radii, widths, insets
        )
    }

    /**
     * Class to support adding [BorderImage] to node with DSL.
     * @param image the image to use as border.
     * @see BorderBuilder.image
     */
    class ImageBuilder internal constructor(private val image: Image) {
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

        internal fun build(): BorderImage =
            BorderImage(image, widths, insets, slices, isFilled, repeatX, repeatY)
    }
}
