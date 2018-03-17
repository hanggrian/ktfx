@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kfx.stage

import javafx.scene.image.Image
import javafx.scene.layout.Region
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import kfx.NO_GETTER
import kfx.noGetter
import kfx.scene.layout.setSizeMax
import kfx.scene.layout.setSizeMin
import kfx.scene.layout.setSizePref
import kotlin.DeprecationLevel.ERROR

/** Minimum width in integer. */
var Stage.widthMin: Int
    get() = minWidth.toInt()
    set(value) = setMinWidth(value.toDouble())

/** Minimum height in integer. */
var Stage.heightMin: Int
    get() = minHeight.toInt()
    set(value) = setMinHeight(value.toDouble())

/** Sets minimum width and height in integer. */
inline fun Stage.setSizeMin(width: Int, height: Int) {
    widthMin = width
    heightMin = height
}

/** Sets minimum width and height in integer. */
// TODO: investigate why this method can't be inlined
inline var Stage.sizeMin: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSizeMin(value, value)

/** Maximum width in integer. */
var Stage.widthMax: Int
    get() = maxWidth.toInt()
    set(value) = setMaxWidth(value.toDouble())

/** Maximum height in integer. */
var Stage.heightMax: Int
    get() = maxHeight.toInt()
    set(value) = setMaxHeight(value.toDouble())

/** Sets maximum width and height in integer. */
inline fun Stage.setSizeMax(width: Int, height: Int) {
    widthMax = width
    heightMax = height
}

/** Sets maximum width and height in integer. */
// TODO: investigate why this method can't be inlined
inline var Stage.sizeMax: Int
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

/** Removes old icons and set a new one to this stage. */
var Stage.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = when (icons.size) {
        0 -> icons += value
        1 -> icons[0] = value
        else -> {
            icons.clear()
            icons += value
        }
    }

/** Creates a stage with options. */
fun stage(
    title: String? = null,
    style: StageStyle = DECORATED,
    init: (Stage.() -> Unit)? = null
): Stage = Stage(style).apply {
    if (title != null) setTitle(title)
    init?.invoke(this)
}