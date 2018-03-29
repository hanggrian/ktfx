@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.scene.layout

import javafx.geometry.Insets
import javafx.scene.layout.Region
import ktfx.internal.NO_GETTER
import ktfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Minimum width in integer. */
var Region.widthMin: Int
    get() = minWidth.toInt()
    set(value) = setMinWidth(value.toDouble())

/** Minimum height in integer. */
var Region.heightMin: Int
    get() = minHeight.toInt()
    set(value) = setMinHeight(value.toDouble())

/** Sets minimum width and height in integer. */
inline fun Region.setSizeMin(width: Int, height: Int) {
    widthMin = width
    heightMin = height
}

/** Sets minimum width and height in integer. */
inline var Region.sizeMin: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSizeMin(value, value)

/** Preferred width in integer. */
var Region.widthPref: Int
    get() = prefWidth.toInt()
    set(value) = setPrefWidth(value.toDouble())

/** Preferred height in integer. */
var Region.heightPref: Int
    get() = prefHeight.toInt()
    set(value) = setPrefHeight(value.toDouble())

/** Sets preferred width and height in integer. */
inline fun Region.setSizePref(width: Int, height: Int) {
    widthPref = width
    heightPref = height
}

/** Sets preferred width and height in integer. */
inline var Region.sizePref: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSizePref(value, value)

/** Maximum width in integer. */
var Region.widthMax: Int
    get() = maxWidth.toInt()
    set(value) = setMaxWidth(value.toDouble())

/** Maximum height in integer. */
var Region.heightMax: Int
    get() = maxHeight.toInt()
    set(value) = setMaxHeight(value.toDouble())

/** Sets maximum width and height in integer. */
inline fun Region.setSizeMax(width: Int, height: Int) {
    widthMax = width
    heightMax = height
}

/** Sets maximum width and height in integer. */
inline var Region.sizeMax: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSizeMax(value, value)

/** Force width and height in integer. */
inline fun Region.setSize(width: Int, height: Int) {
    setSizeMin(width, height)
    setSizePref(width, height)
    setSizeMax(width, height)
}

/** Force width and height in integer. */
inline var Region.size: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSize(value, value)

/** Sets padding to each side with integer. */
fun Region.updatePadding(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

/** Sets padding to all sides with integer. */
var Region.paddings: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value.toDouble()))

/** Top padding in integer. */
inline var Region.paddingTop: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = updatePadding(top = value)

/** Right padding in integer. */
inline var Region.paddingRight: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = updatePadding(right = value)

/** Bottom padding in integer. */
inline var Region.paddingBottom: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = updatePadding(bottom = value)

/** Left padding in integer. */
inline var Region.paddingLeft: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = updatePadding(left = value)