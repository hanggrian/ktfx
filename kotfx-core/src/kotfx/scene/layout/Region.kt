@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

fun Region.minSize(width: Number = minWidth, height: Number = minHeight) {
    minWidth = width.toDouble()
    minHeight = height.toDouble()
}

fun Region.prefSize(width: Number = prefWidth, height: Number = prefHeight) {
    prefWidth = width.toDouble()
    prefHeight = height.toDouble()
}

fun Region.maxSize(width: Number = maxWidth, height: Number = maxHeight) {
    maxWidth = width.toDouble()
    maxHeight = height.toDouble()
}

inline fun Region.size(width: Number, height: Number) {
    minSize(width, height)
    prefSize(width, height)
    maxSize(width, height)
}

// TODO: investigate why this method can't be inlined
var Region.minSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = minSize(value, value)

// TODO: investigate why this method can't be inlined
var Region.prefSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = prefSize(value, value)

// TODO: investigate why this method can't be inlined
var Region.maxSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = maxSize(value, value)

inline var Region.size: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = size(value, value)

fun Region.paddings(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

var Region.paddings: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value.toDouble()))

inline var Region.topPadding: Number
    get() = padding.top
    set(value) = paddings(top = value)

inline var Region.rightPadding: Number
    get() = padding.right
    set(value) = paddings(right = value)

inline var Region.bottomPadding: Number
    get() = padding.bottom
    set(value) = paddings(bottom = value)

inline var Region.leftPadding: Number
    get() = padding.left
    set(value) = paddings(left = value)