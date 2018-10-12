package ktfx.scene.layout

import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals
import kotlin.DeprecationLevel.ERROR

/** Sets a horizontal and vertical gap. */
inline var TilePane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }