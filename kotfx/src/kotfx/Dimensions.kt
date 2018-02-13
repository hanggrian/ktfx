@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Sets padding based on each optional sides. */
inline fun Region.setPadding(
    top: Double = padding.top,
    right: Double = padding.right,
    bottom: Double = padding.bottom,
    left: Double = padding.left
) = setPadding(Insets(top, right, bottom, left))

/** Sets min width and height. */
inline var Region.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

/** Sets pref width and height. */
inline var Region.prefSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value, value)

/** Sets max width and height. */
inline var Region.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

/** Sets a horizontal and vertical gap. */
inline var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }

/** Sets a horizontal and vertical gap. */
inline var GridPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }

/** Sets a horizontal and vertical gap. */
inline var TilePane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }