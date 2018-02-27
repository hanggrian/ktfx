@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

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

fun Stage.minSize(width: Number = minWidth, height: Number = minHeight) {
    minWidth = width.toDouble()
    minHeight = height.toDouble()
}

fun Stage.maxSize(width: Number = maxWidth, height: Number = maxHeight) {
    maxWidth = width.toDouble()
    maxHeight = height.toDouble()
}

fun Stage.size(width: Number = this.width, height: Number = this.height) {
    this.width = width.toDouble()
    this.height = height.toDouble()
}

inline var Stage.minSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = minSize(value, value)

inline var Stage.maxSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = maxSize(value, value)

inline var Stage.size: Number
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

inline var Region.minSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = minSize(value, value)

inline var Region.prefSize: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = prefSize(value, value)

inline var Region.maxSize: Number
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