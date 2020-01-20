@file:JvmMultifileClass
@file:JvmName("RegionKt")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.Region
import ktfx.internal.KtfxInternals

/** Top padding of this [Region]. */
var Region.topPadding: Double
    inline get() = padding.top
    set(value) {
        padding = Insets(value, rightPadding, bottomPadding, leftPadding)
    }

/** Right padding of this [Region]. */
var Region.rightPadding: Double
    inline get() = padding.right
    set(value) {
        padding = Insets(topPadding, value, bottomPadding, leftPadding)
    }

/** Bottom padding of this [Region]. */
var Region.bottomPadding: Double
    inline get() = padding.bottom
    set(value) {
        padding = Insets(topPadding, rightPadding, value, leftPadding)
    }

/** Left padding of this [Region]. */
var Region.leftPadding: Double
    inline get() = padding.left
    set(value) {
        padding = Insets(topPadding, rightPadding, bottomPadding, value)
    }

/** Sets left and right padding of this [Region]. */
var Region.horizontalPadding: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        padding = Insets(topPadding, value, bottomPadding, value)
    }

/** Sets top and bottom padding of this [Region]. */
var Region.verticalPadding: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        padding = Insets(value, rightPadding, value, leftPadding)
    }

/** Sets padding to all sides of this [Region]. */
var Region.allPadding: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    inline set(value) {
        padding = Insets(value)
    }

/** Sets min width and height of region. */
var Region.minSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setMinSize(value, value)

/** Sets pref width and height of region. */
var Region.prefSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    set(value) = setPrefSize(value, value)

/** Sets max width and height of region. */
var Region.maxSize: Double
    @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
    inline set(value) = setMaxSize(value, value)
