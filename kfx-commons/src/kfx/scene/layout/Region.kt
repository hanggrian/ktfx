@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kfx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import kfx.NO_GETTER
import kfx.noGetter
import kotlin.DeprecationLevel.ERROR

var Region.widthMin: Number
    get() = minWidth
    set(value) = setMinWidth(value.toDouble())

var Region.heightMin: Number
    get() = minHeight
    set(value) = setMinHeight(value.toDouble())

var Region.widthPref: Number
    get() = prefWidth
    set(value) = setPrefWidth(value.toDouble())

var Region.heightPref: Number
    get() = prefHeight
    set(value) = setPrefHeight(value.toDouble())

var Region.widthMax: Number
    get() = maxWidth
    set(value) = setMaxWidth(value.toDouble())

var Region.heightMax: Number
    get() = maxHeight
    set(value) = setMaxHeight(value.toDouble())

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

/** Sets padding to each side of this [Region]. */
fun Region.updatePadding(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

/** Sets padding to all sides of this [Region]. */
var Region.paddings: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value.toDouble()))

/** Top padding of this [Region]. */
inline var Region.paddingTop: Number
    get() = padding.top
    set(value) = updatePadding(top = value)

/** Right padding of this [Region]. */
inline var Region.paddingRight: Number
    get() = padding.right
    set(value) = updatePadding(right = value)

/** Bottom padding of this [Region]. */
inline var Region.paddingBottom: Number
    get() = padding.bottom
    set(value) = updatePadding(bottom = value)

/** Left padding of this [Region]. */
inline var Region.paddingLeft: Number
    get() = padding.left
    set(value) = updatePadding(left = value)