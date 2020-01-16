@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals

/** Sets horizontal and vertical gap. */
inline fun FlowPane.setGap(hgap: Double, vgap: Double) {
    this.hgap = hgap
    this.vgap = vgap
}

/** Convenient method to set horizontal and vertical gap to the same value. */
inline var FlowPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setGap(value, value)

/** Sets horizontal and vertical gap. */
inline fun GridPane.setGap(hgap: Double, vgap: Double) {
    this.hgap = hgap
    this.vgap = vgap
}

/** Convenient method to set horizontal and vertical gap to the same value. */
inline var GridPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setGap(value, value)

/** Sets horizontal and vertical gap. */
inline fun TilePane.setGap(hgap: Double, vgap: Double) {
    this.hgap = hgap
    this.vgap = vgap
}

/** Convenient method to set horizontal and vertical gap to the same value. */
inline var TilePane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setGap(value, value)
