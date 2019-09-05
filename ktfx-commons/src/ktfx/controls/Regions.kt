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
import ktfx.internal.KtfxInternals

/** Sets padding to all sides with integer. */
var Region.paddingAll: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        padding = Insets(value)
    }

/** Top and bottom padding. */
inline var Region.paddingVertical: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = updatePadding(top = value, bottom = value)

/** Right and left padding. */
inline var Region.paddingHorizontal: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = updatePadding(right = value, left = value)

/** Top padding. */
inline var Region.paddingTop: Double
    get() = padding.top
    set(value) = updatePadding(top = value)

/** Right padding. */
inline var Region.paddingRight: Double
    get() = padding.right
    set(value) = updatePadding(right = value)

/** Bottom padding. */
inline var Region.paddingBottom: Double
    get() = padding.bottom
    set(value) = updatePadding(bottom = value)

/** Left padding. */
inline var Region.paddingLeft: Double
    get() = padding.left
    set(value) = updatePadding(left = value)

/** Sets padding to each side. */
fun Region.updatePadding(
    top: Double = paddingLeft,
    right: Double = paddingRight,
    bottom: Double = paddingBottom,
    left: Double = paddingLeft
) {
    padding = Insets(top, right, bottom, left)
}

/** Set multiple fills to region. */
fun Region.updateBackground(vararg fills: BackgroundFill) {
    background = Background(*fills)
}

/** Update region's fill with native [Insets]. */
inline fun Region.updateBackground(
    fill: Paint? = null,
    radii: CornerRadii? = null,
    padding: Insets? = null
): Unit = updateBackground(BackgroundFill(fill, radii, padding))

/** Update region's fill with parameterized padding. */
inline fun Region.updateBackground(
    fill: Paint? = null,
    radii: CornerRadii? = null,
    topPadding: Double = paddingLeft,
    rightPadding: Double = paddingRight,
    bottomPadding: Double = paddingBottom,
    leftPadding: Double = paddingLeft
): Unit = updateBackground(
    fill,
    radii,
    Insets(topPadding, rightPadding, bottomPadding, leftPadding)
)

/** Set multiple images to region. */
fun Region.updateBackground(vararg images: BackgroundImage) {
    background = Background(*images)
}

/** Update region's image. */
inline fun Region.updateBackground(
    image: Image,
    repeatX: BackgroundRepeat? = null,
    repeatY: BackgroundRepeat? = null,
    position: BackgroundPosition? = null,
    size: BackgroundSize? = null
): Unit = updateBackground(BackgroundImage(image, repeatX, repeatY, position, size))

/** Sets min width and height of region. */
inline var Region.minSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setMinSize(value, value)

/** Sets pref width and height of region. */
inline var Region.prefSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setPrefSize(value, value)

/** Sets max width and height of region. */
inline var Region.maxSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setMaxSize(value, value)
