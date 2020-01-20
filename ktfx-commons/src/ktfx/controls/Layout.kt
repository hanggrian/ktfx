package ktfx.controls

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals

/** Sets horizontal and vertical gap. */
fun FlowPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal; vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
var FlowPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setGap(value, value)

/** Sets horizontal and vertical gap. */
fun GridPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal; vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
var GridPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setGap(value, value)

/** Sets horizontal and vertical gap. */
fun TilePane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal; vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
var TilePane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setGap(value, value)
