@file:OptIn(ExperimentalContracts::class)

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
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Builds new border with multiple [BorderStroke] and/or [BorderImage].
 *
 * @param builderAction populate newly created stroke and/or image.
 * @return created border.
 */
public inline fun buildBorder(builderAction: BorderBuilder.() -> Unit): Border {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return BorderBuilder().apply(builderAction).build()
}

/**
 * Sets new border with single [BorderStroke].
 *
 * @param builderAction stroke configurator.
 * @return applied border.
 */
public inline fun Region.strokeBorder(
    builderAction: BorderBuilder.StrokeBuilder.() -> Unit,
): Border {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return border { stroke(builderAction) }
}

/**
 * Sets new border with single [BorderImage].
 *
 * @param builderAction image configurator.
 * @return applied border.
 */
public inline fun Region.imageBorder(
    image: Image,
    builderAction: BorderBuilder.ImageBuilder.() -> Unit,
): Border {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return border { image(image, builderAction) }
}

/**
 * Sets new border with multiple [BorderStroke] and/or [BorderImage].
 *
 * @param builderAction populate newly created stroke and/or image.
 * @return applied border.
 */
public inline fun Region.border(builderAction: BorderBuilder.() -> Unit): Border {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return buildBorder(builderAction).also { border = it }
}

/** Border configurator class. */
public class BorderBuilder {
    /** Current strokes within this border. */
    public val strokes: MutableList<BorderStroke> = mutableListOf()

    /** Current images within this border. */
    public val images: MutableList<BorderImage> = mutableListOf()

    /**
     * Append a [BorderStroke].
     *
     * @param builderAction stroke configurator.
     * @return added stroke.
     */
    public inline fun stroke(builderAction: StrokeBuilder.() -> Unit): BorderStroke {
        contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
        return StrokeBuilder().apply(builderAction).build().also { strokes += it }
    }

    /**
     * Append a [BorderImage].
     *
     * @param builderAction image configurator.
     * @return added image.
     */
    public inline fun image(image: Image, builderAction: ImageBuilder.() -> Unit): BorderImage {
        contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
        return ImageBuilder(image).apply(builderAction).build().also { images += it }
    }

    /** Return border based on current configuration. */
    public fun build(): Border = Border(strokes, images)

    /** Border stroke configurator class. */
    public class StrokeBuilder {
        /** The fill to use on the top. If null, defaults to [javafx.scene.paint.Color.BLACK]. */
        public var topStroke: Paint? = null

        /** The fill to use on the right. If null, defaults to the same value as [topStroke]. */
        public var rightStroke: Paint? = null

        /** The fill to use on the bottom. If null, defaults to the same value as [bottomStroke]. */
        public var bottomStroke: Paint? = null

        /** The fill to use on the left. If null, defaults to the same value as [rightStroke]. */
        public var leftStroke: Paint? = null

        /** The style to use on the top. If null, defaults to [BorderStrokeStyle.NONE]. */
        public var topStyle: BorderStrokeStyle? = null

        /** The style to use on the right. If null, defaults to the same value as [topStyle]. */
        public var rightStyle: BorderStrokeStyle? = null

        /** The style to use on the bottom. If null, defaults to the same value as [topStyle]. */
        public var bottomStyle: BorderStrokeStyle? = null

        /** The style to use on the left. If null, defaults to the same value as [rightStyle]. */
        public var leftStyle: BorderStrokeStyle? = null

        /** The radii. If null, we default to square corners by using [CornerRadii.EMPTY]. */
        public var radii: CornerRadii? = null

        /** The thickness of each side. If null, we default to [BorderWidths.DEFAULT]. */
        public var widths: BorderWidths? = null

        /** The insets indicating where to draw the border relative to the region edges. */
        public var insets: Insets? = null

        /** The stroke to use for all sides. If null, we default to [javafx.scene.paint.Color.BLACK]. */
        public var stroke: Paint?
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                topStroke = value
                rightStroke = value
                bottomStroke = value
                leftStroke = value
            }

        /** The style to use for all sides. If null, we default to [BorderStrokeStyle.NONE]. */
        public var style: BorderStrokeStyle?
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                topStyle = value
                rightStyle = value
                bottomStyle = value
                leftStyle = value
            }

        /** Return border stroke based on current configuration. */
        public fun build(): BorderStroke =
            BorderStroke(
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
                insets,
            )
    }

    /** Border image configurator class. */
    public class ImageBuilder(private val image: Image) {
        /**
         * The widths of the border in each dimension. A null value results in [BorderWidths.EMPTY].
         */
        public var widths: BorderWidths? = null

        /**
         * The insets at which to place the border relative to the region. A null value results in
         * [Insets.EMPTY].
         */
        public var insets: Insets? = null

        /** The slices for the image. If null, defaults to [BorderWidths.DEFAULT]. */
        public var slices: BorderWidths? = null

        public var isFilled: Boolean = false

        /**
         * The repeat value for the border image in the x direction. If null, defaults to
         * [BorderRepeat.STRETCH].
         */
        public var repeatX: BorderRepeat? = null

        /**
         * The repeat value for the border image in the y direction. If null, defaults to the same
         * value as repeatX.
         */
        public var repeatY: BorderRepeat? = null

        /**
         * The repeat value for the border image in the x and y direction. If null, defaults to
         * [BorderRepeat.STRETCH].
         */
        public var repeat: BorderRepeat?
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                repeatX = value
                repeatY = value
            }

        /** Return border image based on current configuration. */
        public fun build(): BorderImage =
            BorderImage(
                image,
                widths,
                insets,
                slices,
                isFilled,
                repeatX,
                repeatY,
            )
    }
}
