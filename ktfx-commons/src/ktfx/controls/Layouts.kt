@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.TilePane
import ktfx.internal.KtfxInternals

/** Sets horizontal and vertical gap. */
var FlowPane.gap: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = value.toDouble().let {
        vgap = it
        hgap = it
    }

/** Sets a horizontal and vertical gap. */
var GridPane.gap: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = value.toDouble().let {
        vgap = it
        hgap = it
    }

/** Sets a horizontal and vertical gap. */
var TilePane.gap: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = value.toDouble().let {
        vgap = it
        hgap = it
    }
