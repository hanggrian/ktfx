@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package javafxx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import javafxx.internal.Internals
import kotlin.DeprecationLevel.ERROR

/** Convenient method for overriding the region's computed minimum width and height. */
inline var Region.minSize: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) = setMinSize(value, value)

/** Convenient method for overriding the region's computed preferred width and height. */
inline var Region.prefSize: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) = setPrefSize(value, value)

/** Convenient method for overriding the region's computed maximum width and height. */
inline var Region.maxSize: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) = setMaxSize(value, value)

/** Sets padding to all sides with integer. */
inline var Region.paddingAll: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
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