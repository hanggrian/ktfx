package kotlinfx.scene.layout

import javafx.scene.layout.TilePane
import kotlinfx.internal.NO_GETTER
import kotlinfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
var TilePane.gaps: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }