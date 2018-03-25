package ktfx.scene.layout

import javafx.scene.layout.TilePane
import ktfx.NO_GETTER
import ktfx.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
var TilePane.gaps: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }