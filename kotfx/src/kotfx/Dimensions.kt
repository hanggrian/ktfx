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

inline fun Stage.setMinSize(width: Double, height: Double) {
    minWidth = width
    minHeight = height
}

inline fun Stage.setMaxSize(width: Double, height: Double) {
    maxWidth = width
    maxHeight = height
}

inline fun Stage.setSize(width: Double, height: Double) {
    this.width = width
    this.height = height
}

inline var Stage.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

inline var Stage.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

inline var Stage.size: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSize(value, value)

inline fun Region.setSize(width: Double, height: Double) {
    setMinSize(width, height)
    setPrefSize(width, height)
    setMaxSize(width, height)
}

inline var Region.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

inline var Region.prefSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value, value)

inline var Region.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

inline var Region.size: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSize(value, value)

var Region.topPadding: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = padding.let { setPadding(Insets(value.toDouble(), it.right, it.bottom, it.left)) }

var Region.rightPadding: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = padding.let { setPadding(Insets(it.top, value.toDouble(), it.bottom, it.left)) }

var Region.bottomPadding: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = padding.let { setPadding(Insets(it.top, it.right, value.toDouble(), it.left)) }

var Region.leftPadding: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = padding.let { setPadding(Insets(it.top, it.right, it.bottom, value.toDouble())) }

inline var Region.paddings: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(Insets(value))

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