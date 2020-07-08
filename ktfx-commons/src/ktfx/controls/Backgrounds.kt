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

/** Create multiple [BackgroundFill] and/or [BackgroundImage] using DSL. */
fun buildBackground(builderAction: BackgroundBuilder.() -> Unit): Background =
    BackgroundBuilder().apply(builderAction).build()

/** Add multiple [BackgroundFill] and/or [BackgroundImage] to node using DSL. */
inline fun Region.background(noinline builderAction: BackgroundBuilder.() -> Unit): Background {
    val background = buildBackground(builderAction)
    setBackground(background)
    return background
}

/** Add a new [BackgroundFill] to node using DSL. */
inline fun Region.backgroundFill(noinline builderAction: BackgroundBuilder.FillBuilder.() -> Unit): Background =
    background { fill(builderAction) }

/** Add a new [BackgroundImage] to node using DSL. */
inline fun Region.backgroundImage(
    image: Image,
    noinline builderAction: BackgroundBuilder.ImageBuilder.() -> Unit
): Background = background { image(image, builderAction) }

/**
 * Class to support adding [Background] to node with DSL.
 * @see Region.background
 */
class BackgroundBuilder internal constructor() {
    val fills: MutableList<BackgroundFill> = mutableListOf()
    val images: MutableList<BackgroundImage> = mutableListOf()

    /** Add a new [BackgroundFill] to node using DSL. */
    fun fill(builderAction: FillBuilder.() -> Unit): BackgroundFill {
        val backgroundFill = FillBuilder().apply(builderAction).build()
        fills += backgroundFill
        return backgroundFill
    }

    /** Add a new [BackgroundImage] to node using DSL. */
    fun image(image: Image, builderAction: ImageBuilder.() -> Unit): BackgroundImage {
        val backgroundImage = ImageBuilder(image).apply(builderAction).build()
        images += backgroundImage
        return backgroundImage
    }

    internal fun build(): Background = Background(fills, images)

    /**
     * Class to support adding [BackgroundFill] to node with DSL.
     * @see BackgroundBuilder.fill
     */
    class FillBuilder internal constructor() {
        /** Any Paint. If null, the value [javafx.scene.paint.Color.TRANSPARENT] is used.. */
        var fill: Paint? = null

        /** The corner Radii. If null, the value Radii.EMPTY is used. */
        var radii: CornerRadii? = null

        /** The insets. If null, the value Insets.EMPTY is used. */
        var insets: Insets? = null

        internal fun build(): BackgroundFill = BackgroundFill(fill, radii, insets)
    }

    /**
     * Class to support adding [BackgroundImage] to node with DSL.
     * @param image the image to use as background.
     * @see BackgroundBuilder.image
     */
    class ImageBuilder internal constructor(private val image: Image) {
        /** The repeat for the x axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeatX: BackgroundRepeat? = null

        /** The repeat for the y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeatY: BackgroundRepeat? = null

        /** The repeat for the x and y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeat: BackgroundRepeat?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                repeatX = value
                repeatY = value
            }

        /** The position to use. If null, defaults to [BackgroundPosition.DEFAULT]. */
        var position: BackgroundPosition? = null

        /** The size. If null, defaults to [BackgroundSize.DEFAULT]. */
        var size: BackgroundSize? = null

        internal fun build(): BackgroundImage = BackgroundImage(image, repeatX, repeatY, position, size)
    }
}
