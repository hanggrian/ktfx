package kfx.scene.layout

import javafx.scene.layout.FlowPane
import kfx.NO_GETTER
import kfx.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
var FlowPane.gaps: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }