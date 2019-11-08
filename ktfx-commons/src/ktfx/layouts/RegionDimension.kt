@file:JvmMultifileClass
@file:JvmName("RegionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.layout.Region
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
