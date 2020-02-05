package ktfx.controls

import javafx.scene.layout.FlowPane
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Sets horizontal and vertical gap. */
fun FlowPane.setGap(horizontal: Double, vertical: Double) {
    hgap = horizontal
    vgap = vertical
}

/** Convenient method to set horizontal and vertical gap to the same value. */
inline var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setGap(value, value)
