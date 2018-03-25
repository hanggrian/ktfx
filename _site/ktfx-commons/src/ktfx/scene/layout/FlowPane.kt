package ktfx.scene.layout

import javafx.scene.layout.FlowPane
import ktfx.NO_GETTER
import ktfx.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
var FlowPane.gaps: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }