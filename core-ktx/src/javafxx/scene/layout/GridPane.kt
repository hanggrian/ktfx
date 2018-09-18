package javafxx.scene.layout

import javafx.scene.layout.GridPane
import javafxx.internal.Internals
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var GridPane.gap: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }