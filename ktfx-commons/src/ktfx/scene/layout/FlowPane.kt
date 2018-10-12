package ktfx.scene.layout

import javafx.scene.layout.FlowPane
import ktfx.internal.KtfxInternals
import kotlin.DeprecationLevel.ERROR

/** Sets horizontal and vertical gap. */
inline var FlowPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }