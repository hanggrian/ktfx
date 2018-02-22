@file:Suppress("UsePropertyAccessSyntax")

package kotfx

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import javafx.stage.Stage
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets min width and height to this stage. */
fun Stage.minSize(width: Number, height: Number) {
    setMinWidth(width.toDouble())
    setMinHeight(height.toDouble())
}

/** Sets width and height to this stage. */
fun Stage.size(width: Number, height: Number) {
    setWidth(width.toDouble())
    setHeight(height.toDouble())
}

/** Sets max width and height to this stage. */
fun Stage.maxSize(width: Number, height: Number) {
    setMaxWidth(width.toDouble())
    setMaxHeight(height.toDouble())
}

/** Sets min width and height to this stage. */
var Stage.minSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = minSize(value, value)

/** Sets width and height to this stage. */
var Stage.size: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = size(value, value)

/** Sets max width and height to this stage. */
var Stage.maxSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = maxSize(value, value)

/** Sets min width and height to this region. */
fun Region.minSize(width: Number, height: Number) {
    setMinWidth(width.toDouble())
    setMinHeight(height.toDouble())
}

/** Sets width and height to this region. */
fun Region.prefSize(width: Number, height: Number) {
    setPrefWidth(width.toDouble())
    setPrefHeight(height.toDouble())
}

/** Sets max width and height to this region. */
fun Region.maxSize(width: Number, height: Number) {
    setMaxWidth(width.toDouble())
    setMaxHeight(height.toDouble())
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

/** Sets padding on each side. */
fun Region.padding(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

/** Sets padding on all sides. */
fun Region.padding(all: Number) = setPadding(Insets(all.toDouble()))

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