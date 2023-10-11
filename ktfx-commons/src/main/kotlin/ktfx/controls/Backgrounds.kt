@file:Suppress("NOTHING_TO_INLINE")

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
inline fun buildBackground(
    builderAction: BackgroundBuilder.() -> Unit
): Background = BackgroundBuilder().apply(builderAction).build()

/**
 * Sets new background with multiple [BackgroundFill] and/or [BackgroundImage].
 *
 * @param builderAction populate newly created fill and/or image.
 * @return applied background.
 */
inline fun Region.background(
    noinline builderAction: BackgroundBuilder.() -> Unit
): Background = buildBackground(builderAction).also { background = it }

/**
 * Sets new background with single [BackgroundFill].
 *
 * @param builderAction fill configurator.
 * @return applied background.
 */
inline fun Region.backgroundFill(
    noinline builderAction: BackgroundBuilder.FillBuilder.() -> Unit
): Background = background { fill(builderAction) }

/**
 * Sets new background with single [BackgroundImage].
 *
 * @param builderAction image configurator.
 * @return applied background.
 */
inline fun Region.backgroundImage(
    image: Image,
    noinline builderAction: BackgroundBuilder.ImageBuilder.() -> Unit
): Background = background { image(image, builderAction) }

/** Background configurator class. */
class BackgroundBuilder {
    /** Current fills within this background. */
    val fills: MutableList<BackgroundFill> = mutableListOf()

    /** Current images within this background. */
    val images: MutableList<BackgroundImage> = mutableListOf()

    /**
     * Append a [BackgroundFill].
     *
     * @param builderAction fill configurator.
     * @return added fill.
     */
    inline fun fill(builderAction: FillBuilder.() -> Unit): BackgroundFill =
        FillBuilder().apply(builderAction).build().also { fills += it }

    /**
     * Append a [BackgroundImage].
     *
     * @param builderAction image configurator.
     * @return added image.
     */
    inline fun image(image: Image, builderAction: ImageBuilder.() -> Unit): BackgroundImage =
        ImageBuilder(image).apply(builderAction).build().also { images += it }

    /** Return background based on current configuration. */
    fun build(): Background = Background(fills, images)

    /** Background fill configurator class. */
    class FillBuilder {
        /** Any Paint. If null, the value [javafx.scene.paint.Color.TRANSPARENT] is used.. */
        var fill: Paint? = null

        /** The corner Radii. If null, the value Radii.EMPTY is used. */
        var radii: CornerRadii? = null

        /** The insets. If null, the value Insets.EMPTY is used. */
        var insets: Insets? = null

        /** Return background fill based on current configuration. */
        fun build(): BackgroundFill = BackgroundFill(fill, radii, insets)
    }

    /** Background image configurator class. */
    class ImageBuilder(private val image: Image) {
        /** The repeat for the x axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeatX: BackgroundRepeat? = null

        /** The repeat for the y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeatY: BackgroundRepeat? = null

        /** The repeat for the x and y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeat: BackgroundRepeat?
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                repeatX = value
                repeatY = value
            }

        /** The position to use. If null, defaults to [BackgroundPosition.DEFAULT]. */
        var position: BackgroundPosition? = null

        /** The size. If null, defaults to [BackgroundSize.DEFAULT]. */
        var size: BackgroundSize? = null

        /** Return background image based on current configuration. */
        fun build(): BackgroundImage = BackgroundImage(image, repeatX, repeatY, position, size)
    }
}
