package kotlinfx.scene.layout

import javafx.scene.layout.FlowPane
import kotlinfx.internal.NO_GETTER
import kotlinfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
var FlowPane.gaps: Number
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }