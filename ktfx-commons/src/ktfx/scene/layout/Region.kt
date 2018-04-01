@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import ktfx.internal.KtFXInternals.NO_GETTER
import ktfx.internal.KtFXInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets padding to all sides with integer. */
inline var Region.paddingAll: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value))

/** Top padding in integer. */
inline var Region.paddingTop: Double
    get() = padding.top
    set(value) = updatePadding(top = value)

/** Right padding in integer. */
inline var Region.paddingRight: Double
    get() = padding.right
    set(value) = updatePadding(right = value)

/** Bottom padding in integer. */
inline var Region.paddingBottom: Double
    get() = padding.bottom
    set(value) = updatePadding(bottom = value)

/** Left padding in integer. */
inline var Region.paddingLeft: Double
    get() = padding.left
    set(value) = updatePadding(left = value)

/** Sets padding to each side with integer. */
inline fun Region.updatePadding(
    top: Double = paddingTop,
    right: Double = paddingRight,
    bottom: Double = paddingBottom,
    left: Double = paddingLeft
) = setPadding(Insets(top, right, bottom, left))