package ktfx.scene.layout

import javafx.scene.layout.FlowPane
import ktfx.internal.KtFXInternals.NO_GETTER
import ktfx.internal.KtFXInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }