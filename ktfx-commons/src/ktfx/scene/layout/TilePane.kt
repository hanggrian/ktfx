package ktfx.scene.layout

import javafx.scene.layout.TilePane
import ktfx.internal.Internals
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var TilePane.gap: Double
    @Deprecated(Internals.NO_GETTER, level = ERROR) get() = Internals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }