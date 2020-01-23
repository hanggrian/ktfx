package ktfx.controls

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.TilePane
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Sets horizontal and vertical gap. */
fun FlowPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal; vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) = setGap(value, value)

/** Sets horizontal and vertical gap. */
fun GridPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal; vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
var GridPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) = setGap(value, value)

/** Sets horizontal and vertical gap. */
fun TilePane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal; vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
var TilePane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) = setGap(value, value)
