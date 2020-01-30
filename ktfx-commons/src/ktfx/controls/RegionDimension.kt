@file:JvmMultifileClass
@file:JvmName("RegionKt")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.Region
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Top padding of this [Region]. */
inline var Region.topPadding: Double
    get() = padding.top
    set(value) {
        padding = Insets(value, rightPadding, bottomPadding, leftPadding)
    }

/** Right padding of this [Region]. */
inline var Region.rightPadding: Double
    get() = padding.right
    set(value) {
        padding = Insets(topPadding, value, bottomPadding, leftPadding)
    }

/** Bottom padding of this [Region]. */
inline var Region.bottomPadding: Double
    get() = padding.bottom
    set(value) {
        padding = Insets(topPadding, rightPadding, value, leftPadding)
    }

/** Left padding of this [Region]. */
inline var Region.leftPadding: Double
    get() = padding.left
    set(value) {
        padding = Insets(topPadding, rightPadding, bottomPadding, value)
    }

/** Sets left and right padding of this [Region]. */
inline var Region.horizontalPadding: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        padding = Insets(topPadding, value, bottomPadding, value)
    }

/** Sets top and bottom padding of this [Region]. */
inline var Region.verticalPadding: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        padding = Insets(value, rightPadding, value, leftPadding)
    }

/** Sets padding to all sides of this [Region]. */
inline var Region.allPadding: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        padding = Insets(value)
    }

/** Sets min width and height of region. */
inline var Region.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

/** Sets pref width and height of region. */
inline var Region.prefSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value, value)

/** Sets max width and height of region. */
inline var Region.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)
