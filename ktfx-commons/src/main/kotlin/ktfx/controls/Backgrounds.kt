package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.image.Image
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.BackgroundImage
import javafx.scene.layout.BackgroundPosition
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.layout.BackgroundSize
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Paint
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/**
 * Builds new background with multiple [BackgroundFill] and/or [BackgroundImage].
 *
 * @param builderAction populate newly created fill and/or image.
 * @return created background.
 */
public inline fun buildBackground(builderAction: BackgroundBuilder.() -> Unit): Background =
    BackgroundBuilder().apply(builderAction).build()

/**
 * Sets new background with multiple [BackgroundFill] and/or [BackgroundImage].
 *
 * @param builderAction populate newly created fill and/or image.
 * @return applied background.
 */
public fun Region.background(builderAction: BackgroundBuilder.() -> Unit): Background =
    buildBackground(builderAction).also { background = it }

/**
 * Sets new background with single [BackgroundFill].
 *
 * @param builderAction fill configurator.
 * @return applied background.
 */
public fun Region.fillBackground(
    builderAction: BackgroundBuilder.FillBuilder.() -> Unit,
): Background = background { fill(builderAction) }

/**
 * Sets new background with single [BackgroundImage].
 *
 * @param builderAction image configurator.
 * @return applied background.
 */
public fun Region.imageBackground(
    image: Image,
    builderAction: BackgroundBuilder.ImageBuilder.() -> Unit,
): Background = background { image(image, builderAction) }

/** Background configurator class. */
public class BackgroundBuilder {
    /** Current fills within this background. */
    public val fills: MutableList<BackgroundFill> = mutableListOf()

    /** Current images within this background. */
    public val images: MutableList<BackgroundImage> = mutableListOf()

    /**
     * Append a [BackgroundFill].
     *
     * @param builderAction fill configurator.
     * @return added fill.
     */
    public inline fun fill(builderAction: FillBuilder.() -> Unit): BackgroundFill =
        FillBuilder().apply(builderAction).build().also { fills += it }

    /**
     * Append a [BackgroundImage].
     *
     * @param builderAction image configurator.
     * @return added image.
     */
    public inline fun image(image: Image, builderAction: ImageBuilder.() -> Unit): BackgroundImage =
        ImageBuilder(image).apply(builderAction).build().also { images += it }

    /** Return background based on current configuration. */
    public fun build(): Background = Background(fills, images)

    /** Background fill configurator class. */
    public class FillBuilder {
        /** Any Paint. If null, the value [javafx.scene.paint.Color.TRANSPARENT] is used.. */
        public var fill: Paint? = null

        /** The corner Radii. If null, the value Radii.EMPTY is used. */
        public var radii: CornerRadii? = null

        /** The insets. If null, the value Insets.EMPTY is used. */
        public var insets: Insets? = null

        /** Return background fill based on current configuration. */
        public fun build(): BackgroundFill = BackgroundFill(fill, radii, insets)
    }

    /** Background image configurator class. */
    public class ImageBuilder(private val image: Image) {
        /** The repeat for the x axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        public var repeatX: BackgroundRepeat? = null

        /** The repeat for the y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        public var repeatY: BackgroundRepeat? = null

        /** The position to use. If null, defaults to [BackgroundPosition.DEFAULT]. */
        public var position: BackgroundPosition? = null

        /** The size. If null, defaults to [BackgroundSize.DEFAULT]. */
        public var size: BackgroundSize? = null

        /**
         * The repeat for the x and y axis. If null, this value defaults to
         * [BackgroundRepeat.REPEAT].
         */
        public var repeat: BackgroundRepeat?
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                repeatX = value
                repeatY = value
            }

        /** Return background image based on current configuration. */
        public fun build(): BackgroundImage =
            BackgroundImage(image, repeatX, repeatY, position, size)
    }
}
