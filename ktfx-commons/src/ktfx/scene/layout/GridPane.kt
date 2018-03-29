package ktfx.scene.layout

import javafx.scene.layout.GridPane
import ktfx.internal.NO_GETTER
import ktfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var GridPane.gaps: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }