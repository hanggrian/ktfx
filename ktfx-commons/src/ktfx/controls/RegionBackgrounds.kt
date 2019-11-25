@file:JvmMultifileClass
@file:JvmName("RegionKt")
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

/**
 * Class to support adding backgrounds to node with Kotlin DSL.
 *
 * @see Region.background
 */
class BackgroundBuilder internal constructor() {
    private val fills: MutableList<BackgroundFill> = mutableListOf()
    private val images: MutableList<BackgroundImage> = mutableListOf()

    /** Add a new [BackgroundFill] to node with the specified fill, radii, and insets. */
    fun fill(
        fill: Paint? = null,
        radii: CornerRadii? = null,
        insets: Insets? = null
    ): BackgroundFill = BackgroundFill(fill, radii, insets).also { fills += it }

    /**
     * Add a new [BackgroundImage] to node.
     * The image must be specified or a NullPointerException will be thrown.
     *
     * @param image the image to use. This cannot be null.
     * @param repeatX the BackgroundRepeat for the x axis. If null, this value defaults to REPEAT.
     * @param repeatY the BackgroundRepeat for the y axis. If null, this value defaults to REPEAT.
     * @param position the BackgroundPosition to use. If null, defaults to BackgroundPosition.DEFAULT.
     * @param size the BackgroundSize. If null, defaults to BackgroundSize.DEFAULT.
     */
    fun image(
        image: Image,
        repeatX: BackgroundRepeat? = null,
        repeatY: BackgroundRepeat? = null,
        position: BackgroundPosition? = null,
        size: BackgroundSize? = null
    ): BackgroundImage = BackgroundImage(image, repeatX, repeatY, position, size).also { images += it }

    /**
     * Add a new [BackgroundImage] to node using string url.
     * The image must be specified or a NullPointerException will be thrown.
     *
     * @param image the image to use. This cannot be null.
     * @param repeatX the BackgroundRepeat for the x axis. If null, this value defaults to REPEAT.
     * @param repeatY the BackgroundRepeat for the y axis. If null, this value defaults to REPEAT.
     * @param position the BackgroundPosition to use. If null, defaults to BackgroundPosition.DEFAULT.
     * @param size the BackgroundSize. If null, defaults to BackgroundSize.DEFAULT.
     */
    inline fun image(
        image: String,
        repeatX: BackgroundRepeat? = null,
        repeatY: BackgroundRepeat? = null,
        position: BackgroundPosition? = null,
        size: BackgroundSize? = null
    ): BackgroundImage = image(Image(image), repeatX, repeatY, position, size)

    internal fun build(): Background =
        Background(fills, images)
}

/** Invokes DSL to append [BackgroundFill] and [BackgroundImage] to this [Region]. */
fun Region.background(block: BackgroundBuilder.() -> Unit): Background =
    BackgroundBuilder().apply(block).build().also { background = it }

/**
 * Quickly adding background fill without DSL.
 *
 * @see BackgroundBuilder.fill
 */
inline fun Region.backgroundFill(
    fill: Paint? = null,
    radii: CornerRadii? = null,
    insets: Insets? = null
): Background = background { fill(fill, radii, insets) }

/**
 * Quickly adding background image without DSL.
 *
 * @see BackgroundBuilder.image
 */
inline fun Region.backgroundImage(
    image: Image,
    repeatX: BackgroundRepeat? = null,
    repeatY: BackgroundRepeat? = null,
    position: BackgroundPosition? = null,
    size: BackgroundSize? = null
): Background = background { image(image, repeatX, repeatY, position, size) }

/**
 * Quickly adding background image without DSL.
 *
 * @see BackgroundBuilder.image
 */
inline fun Region.backgroundImage(
    image: String,
    repeatX: BackgroundRepeat? = null,
    repeatY: BackgroundRepeat? = null,
    position: BackgroundPosition? = null,
    size: BackgroundSize? = null
): Background = background { image(image, repeatX, repeatY, position, size) }
