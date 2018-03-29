@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import ktfx.internal.NO_GETTER
import ktfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets padding to all sides with integer. */
inline var Region.paddings: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value))

/** Sets padding to each side with integer. */
inline fun Region.updatePadding(
    top: Double = padding.top,
    right: Double = padding.right,
    bottom: Double = padding.bottom,
    left: Double = padding.left
) = setPadding(Insets(top, right, bottom, left))

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