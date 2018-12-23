@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
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

/** Convenient method for overriding the region's computed minimum width and height. */
inline var Region.minSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setMinSize(value, value)

/** Convenient method for overriding the region's computed preferred width and height. */
inline var Region.prefSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setPrefSize(value, value)

/** Convenient method for overriding the region's computed maximum width and height. */
inline var Region.maxSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setMaxSize(value, value)

/** Sets padding to all sides with integer. */
inline var Region.paddingAll: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        padding = Insets(value)
    }

/** Top and bottom padding. */
inline var Region.paddingVertical: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = updatePadding(top = value, bottom = value)

/** Right and left padding. */
inline var Region.paddingHorizontal: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = updatePadding(right = value, left = value)

/** Top padding. */
inline var Region.paddingTop: Double
    get() = padding.top
    set(value) = updatePadding(top = value)

/** Right padding. */
inline var Region.paddingRight: Double
    get() = padding.right
    set(value) = updatePadding(right = value)

/** Bottom padding. */
inline var Region.paddingBottom: Double
    get() = padding.bottom
    set(value) = updatePadding(bottom = value)

/** Left padding. */
inline var Region.paddingLeft: Double
    get() = padding.left
    set(value) = updatePadding(left = value)

/** Sets padding to each side. */
inline fun Region.updatePadding(
    top: Double = paddingTop,
    right: Double = paddingRight,
    bottom: Double = paddingBottom,
    left: Double = paddingLeft
) {
    padding = Insets(top, right, bottom, left)
}