package javafxx.scene.layout

import javafx.scene.layout.FlowPane
import javafxx.internal.Internals
import kotlin.DeprecationLevel.ERROR

/** Sets horizontal and vertical gap. */
inline var FlowPane.gap: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }