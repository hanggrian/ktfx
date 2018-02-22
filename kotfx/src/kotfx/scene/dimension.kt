@file:JvmMultifileClass
@file:JvmName("ScenesKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets min width and height to this stage. */
fun Stage.minSize(width: Number? = null, height: Number? = null) {
    if (width != null) setMinWidth(width.toDouble())
    if (height != null) setMinHeight(height.toDouble())
}

/** Sets max width and height to this stage. */
fun Stage.maxSize(width: Number? = null, height: Number? = null) {
    if (width != null) setMaxWidth(width.toDouble())
    if (height != null) setMaxHeight(height.toDouble())
}

/** Sets width and height to this stage. */
fun Stage.size(width: Number? = null, height: Number? = null) {
    if (width != null) setWidth(width.toDouble())
    if (height != null) setHeight(height.toDouble())
}

/** Sets min width and height to this stage. */
var Stage.minSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = minSize(value, value)

/** Sets max width and height to this stage. */
var Stage.maxSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = maxSize(value, value)

/** Sets width and height to this stage. */
var Stage.size: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = size(value, value)

/** Sets min width and height to this region. */
fun Region.minSize(width: Number? = null, height: Number? = null) {
    if (width != null) setMinWidth(width.toDouble())
    if (height != null) setMinHeight(height.toDouble())
}

/** Sets width and height to this region. */
fun Region.prefSize(width: Number? = null, height: Number? = null) {
    if (width != null) setPrefWidth(width.toDouble())
    if (height != null) setPrefHeight(height.toDouble())
}

/** Sets max width and height to this region. */
fun Region.maxSize(width: Number? = null, height: Number? = null) {
    if (width != null) setMaxWidth(width.toDouble())
    if (height != null) setMaxHeight(height.toDouble())
}

fun Region.size(width: Number, height: Number) {
    minSize(width, height)
    prefSize(width, height)
    maxSize(width, height)
}

/** Sets min width and height. */
var Region.minSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = minSize(value, value)

/** Sets pref width and height. */
var Region.prefSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = prefSize(value, value)

/** Sets max width and height. */
var Region.maxSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = maxSize(value, value)

var Region.size: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = size(value, value)

/** Sets padding on each side. */
fun Region.padding(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

/** Sets padding on all sides. */
fun Region.padding(all: Number) = setPadding(Insets(all.toDouble()))

fun HBox.spacing(spacing: Number) = setSpacing(spacing.toDouble())

fun VBox.spacing(spacing: Number) = setSpacing(spacing.toDouble())

/** Sets a horizontal and vertical gap. */
var FlowPane.gap: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }

/** Sets a horizontal and vertical gap. */
var GridPane.gap: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }

/** Sets a horizontal and vertical gap. */
var TilePane.gap: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }