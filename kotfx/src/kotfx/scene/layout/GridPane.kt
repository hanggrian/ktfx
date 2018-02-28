package kotfx.scene.layout

import javafx.scene.layout.GridPane
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter

/** Sets a horizontal and vertical gap. */
var GridPane.gap: Number
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) {
        vgap = value.toDouble()
        hgap = value.toDouble()
    }