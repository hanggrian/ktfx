package javafxx.scene.layout

import javafx.scene.layout.FlowPane
import javafxx.internal.Internals.NO_GETTER
import javafxx.internal.Internals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets horizontal and vertical gap. */
inline var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }