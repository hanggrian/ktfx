@file:JvmMultifileClass
@file:JvmName("RegionKt")

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
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Create multiple [BackgroundFill] and/or [BackgroundImage] using DSL. */
inline fun buildBackground(builder: BackgroundBuilder.() -> Unit): Background =
    BackgroundBuilder().apply(builder).build()

/** Add multiple [BackgroundFill] and/or [BackgroundImage] to node using DSL. */
inline fun Region.background(builder: BackgroundBuilder.() -> Unit): Background =
    buildBackground(builder).also { background = it }

/** Add a new [BackgroundFill] to node using DSL. */
inline fun Region.backgroundFill(fillBuilder: BackgroundBuilder.FillBuilder.() -> Unit): Background =
    background { fill(fillBuilder) }

/** Add a new [BackgroundImage] to node using DSL. */
inline fun Region.backgroundImage(image: Image, imageBuilder: BackgroundBuilder.ImageBuilder.() -> Unit): Background =
    background { image(image, imageBuilder) }

/**
 * Class to support adding [Background] to node with DSL.
 *
 * @see Region.background
 */
class BackgroundBuilder @PublishedApi internal constructor() {
    val fills: MutableList<BackgroundFill> = mutableListOf()
    val images: MutableList<BackgroundImage> = mutableListOf()

    /** Add a new [BackgroundFill] to node using DSL. */
    inline fun fill(fillBuilder: FillBuilder.() -> Unit): BackgroundFill =
        FillBuilder().apply(fillBuilder).build().also { fills += it }

    /** Add a new [BackgroundImage] to node using DSL. */
    inline fun image(image: Image, imageBuilder: ImageBuilder.() -> Unit): BackgroundImage =
        ImageBuilder(image).apply(imageBuilder).build().also { images += it }

    @PublishedApi internal fun build(): Background = Background(fills, images)

    /**
     * Class to support adding [BackgroundFill] to node with DSL.
     *
     * @see BackgroundBuilder.fill
     */
    class FillBuilder @PublishedApi internal constructor() {
        /** Any Paint. If null, the value [javafx.scene.paint.Color.TRANSPARENT] is used.. */
        var fill: Paint? = null

        /** The corner Radii. If null, the value Radii.EMPTY is used. */
        var radii: CornerRadii? = null

        /** The insets. If null, the value Insets.EMPTY is used. */
        var insets: Insets? = null

        @PublishedApi internal fun build(): BackgroundFill = BackgroundFill(fill, radii, insets)
    }

    /**
     * Class to support adding [BackgroundImage] to node with DSL.
     *
     * @param image the image to use as background.
     * @see BackgroundBuilder.image
     */
    class ImageBuilder @PublishedApi internal constructor(private val image: Image) {
        /** The repeat for the x axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeatX: BackgroundRepeat? = null

        /** The repeat for the y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeatY: BackgroundRepeat? = null

        /** The repeat for the x and y axis. If null, this value defaults to [BackgroundRepeat.REPEAT]. */
        var repeat: BackgroundRepeat?
            @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
            set(value) {
                repeatX = value; repeatY = value
            }

        /** The position to use. If null, defaults to [BackgroundPosition.DEFAULT]. */
        var position: BackgroundPosition? = null

        /** The size. If null, defaults to [BackgroundSize.DEFAULT]. */
        var size: BackgroundSize? = null

        @PublishedApi internal fun build(): BackgroundImage = BackgroundImage(image, repeatX, repeatY, position, size)
    }
}
