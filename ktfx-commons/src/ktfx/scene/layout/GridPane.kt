package ktfx.scene.layout

import javafx.scene.layout.GridPane
import ktfx.internal.Internals
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var GridPane.gap: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }