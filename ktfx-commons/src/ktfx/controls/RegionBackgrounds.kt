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

/** Set multiple fills to region's background. */
fun Region.updateBackground(vararg fills: BackgroundFill) {
    background = Background(*fills)
}

/** Update region's background fill with native [Insets]. */
inline fun Region.updateBackground(
    fill: Paint? = null,
    radii: CornerRadii? = null,
    padding: Insets? = null
): Unit = updateBackground(BackgroundFill(fill, radii, padding))

/** Update region's background fill with parameterized padding. */
inline fun Region.updateBackground(
    fill: Paint? = null,
    radii: CornerRadii? = null,
    topPadding: Double = 0.0,
    rightPadding: Double = 0.0,
    bottomPadding: Double = 0.0,
    leftPadding: Double = 0.0
): Unit = updateBackground(
    fill,
    radii,
    Insets(topPadding, rightPadding, bottomPadding, leftPadding)
)

/** Set multiple images to region's background. */
fun Region.updateBackground(vararg images: BackgroundImage) {
    background = Background(*images)
}

/** Update region's background image. */
inline fun Region.updateBackground(
    image: Image,
    repeatX: BackgroundRepeat? = null,
    repeatY: BackgroundRepeat? = null,
    position: BackgroundPosition? = null,
    size: BackgroundSize? = null
): Unit = updateBackground(BackgroundImage(image, repeatX, repeatY, position, size))
