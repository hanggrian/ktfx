@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Configure spacing of this [FlowPane]. */
var FlowPane.gap: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        hgap = value.first.toDouble()
        vgap = value.second.toDouble()
    }

/** Configure spacing of this [GridPane]. */
var GridPane.gap: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        hgap = value.first.toDouble()
        vgap = value.second.toDouble()
    }

/** Configure spacing of this [TilePane]. */
var TilePane.gap: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        hgap = value.first.toDouble()
        vgap = value.second.toDouble()
    }

/** Configure all padding of this [Region]. */
infix fun Region.padding(all: Number) {
    padding = Insets(all.toDouble())
}

/** Configure each padding of this [Region]. */
fun Region.padding(horizontal: Number? = null, vertical: Number? = null): Unit = padding(
    vertical ?: padding.top,
    horizontal ?: padding.right,
    vertical ?: padding.bottom,
    horizontal ?: padding.left
)

/** Configure each padding of this [Region]. */
fun Region.padding(
    top: Number = padding.top,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) {
    padding = Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble())
}

/** Sets min width and height of region. */
var Region.minSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value.first.toDouble(), value.second.toDouble())

/** Sets pref width and height of region. */
var Region.prefSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value.first.toDouble(), value.second.toDouble())

/** Sets max width and height of region. */
var Region.maxSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value.first.toDouble(), value.second.toDouble())
