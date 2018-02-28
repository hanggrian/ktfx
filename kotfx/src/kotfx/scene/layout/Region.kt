@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter

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

fun Region.size(width: Number, height: Number) {
    minSize(width, height)
    prefSize(width, height)
    maxSize(width, height)
}

var Region.minSize: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = minSize(value, value)

var Region.prefSize: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = prefSize(value, value)

var Region.maxSize: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = maxSize(value, value)

var Region.size: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = size(value, value)

fun Region.paddings(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

var Region.paddings: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value.toDouble()))

var Region.topPadding: Number
    get() = padding.top
    set(value) = paddings(top = value)

var Region.rightPadding: Number
    get() = padding.right
    set(value) = paddings(right = value)

var Region.bottomPadding: Number
    get() = padding.bottom
    set(value) = paddings(bottom = value)

var Region.leftPadding: Number
    get() = padding.left
    set(value) = paddings(left = value)