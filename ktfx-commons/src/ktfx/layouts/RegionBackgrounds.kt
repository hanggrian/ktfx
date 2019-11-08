@file:JvmMultifileClass
@file:JvmName("RegionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

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

class BackgroundBuilder internal constructor() {
    private val fills: MutableList<BackgroundFill> = mutableListOf()
    private val images: MutableList<BackgroundImage> = mutableListOf()

    fun fill(
        fill: Paint? = null,
        radii: CornerRadii? = null,
        insets: Insets? = null
    ): BackgroundFill = BackgroundFill(fill, radii, insets).also { fills += it }

    fun image(
        image: Image,
        repeatX: BackgroundRepeat? = null,
        repeatY: BackgroundRepeat? = null,
        position: BackgroundPosition? = null,
        size: BackgroundSize? = null
    ): BackgroundImage = BackgroundImage(image, repeatX, repeatY, position, size).also { images += it }

    inline fun image(
        image: String,
        repeatX: BackgroundRepeat? = null,
        repeatY: BackgroundRepeat? = null,
        position: BackgroundPosition? = null,
        size: BackgroundSize? = null
    ): BackgroundImage = image(Image(image), repeatX, repeatY, position, size)

    fun build(): Background =
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
