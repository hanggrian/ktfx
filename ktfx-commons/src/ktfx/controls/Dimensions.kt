@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Sets horizontal and vertical gap of this [FlowPane]. */
inline fun FlowPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal
    vgap = vertical
}

/** Convenient method to set horizontal and vertical gap of this [FlowPane] to the same value. */
inline var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setGap(value, value)

/** Sets horizontal and vertical gap of this [GridPane]. */
inline fun GridPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal
    vgap = vertical
}

/** Convenient method to set horizontal and vertical gap of this [GridPane] to the same value. */
inline var GridPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setGap(value, value)

/** Sets horizontal and vertical gap of this [GridPane]. */
inline fun TilePane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal
    vgap = vertical
}

/** Convenient method to set horizontal and vertical gap of this [GridPane] to the same value. */
inline var TilePane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setGap(value, value)

/** Top padding of this [Region]. */
inline var Region.topPadding: Double
    get() = padding.top
    set(value) {
        padding = Insets(value, rightPadding, bottomPadding, leftPadding)
    }

/** Right padding of this [Region]. */
inline var Region.rightPadding: Double
    get() = padding.right
    set(value) {
        padding = Insets(topPadding, value, bottomPadding, leftPadding)
    }

/** Bottom padding of this [Region]. */
inline var Region.bottomPadding: Double
    get() = padding.bottom
    set(value) {
        padding = Insets(topPadding, rightPadding, value, leftPadding)
    }

/** Left padding of this [Region]. */
inline var Region.leftPadding: Double
    get() = padding.left
    set(value) {
        padding = Insets(topPadding, rightPadding, bottomPadding, value)
    }

/** Sets left and right padding of this [Region]. */
inline var Region.horizontalPadding: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        padding = Insets(topPadding, value, bottomPadding, value)
    }

/** Sets top and bottom padding of this [Region]. */
inline var Region.verticalPadding: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        padding = Insets(value, rightPadding, value, leftPadding)
    }

/** Sets padding to all sides of this [Region]. */
inline var Region.paddings: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        padding = Insets(value)
    }

/** Sets min width and height of region. */
inline var Region.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

/** Sets pref width and height of region. */
inline var Region.prefSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value, value)

/** Sets max width and height of region. */
inline var Region.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)
