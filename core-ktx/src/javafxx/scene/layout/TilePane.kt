package javafxx.scene.layout

import javafx.scene.layout.TilePane
import javafxx.internal.KtFXInternals.NO_GETTER
import javafxx.internal.KtFXInternals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var TilePane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }