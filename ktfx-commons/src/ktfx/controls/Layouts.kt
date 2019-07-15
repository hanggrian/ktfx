@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
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

/** Sets padding to all sides with integer. */
var Region.paddingAll: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        padding = Insets(value.toDouble())
    }

/** Top and bottom padding. */
inline var Region.paddingVertical: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = updatePadding(top = value, bottom = value)

/** Right and left padding. */
inline var Region.paddingHorizontal: Number
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = updatePadding(right = value, left = value)

/** Top padding. */
inline var Region.paddingTop: Number
    get() = padding.top
    set(value) = updatePadding(top = value)

/** Right padding. */
inline var Region.paddingRight: Number
    get() = padding.right
    set(value) = updatePadding(right = value)

/** Bottom padding. */
inline var Region.paddingBottom: Number
    get() = padding.bottom
    set(value) = updatePadding(bottom = value)

/** Left padding. */
inline var Region.paddingLeft: Number
    get() = padding.left
    set(value) = updatePadding(left = value)

/** Sets padding to each side. */
fun Region.updatePadding(
    top: Number = padding.left,
    right: Number = padding.right,
    bottom: Number = padding.bottom,
    left: Number = padding.left
) {
    padding = Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble())
}
