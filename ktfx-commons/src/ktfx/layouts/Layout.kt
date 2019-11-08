@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals

/** Sets horizontal and vertical gap. */
inline var FlowPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }

/** Sets a horizontal and vertical gap. */
inline var GridPane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }

/** Sets a horizontal and vertical gap. */
inline var TilePane.gap: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        vgap = value
        hgap = value
    }
