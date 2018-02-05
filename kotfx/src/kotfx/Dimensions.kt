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

@JvmOverloads
inline fun Region.setPadding(
        top: Double = padding.top,
        right: Double = padding.right,
        bottom: Double = padding.bottom,
        left: Double = padding.left
): Unit = setPadding(Insets(top, right, bottom, left))

inline var Region.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

inline var Region.prefSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value, value)

inline var Region.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

inline var Region.forcedSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        minSize = value
        prefSize = value
        maxSize = value
    }

inline var Region.forcedWidth: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        minWidth = value.toDouble()
        prefWidth = value.toDouble()
        maxWidth = value.toDouble()
    }

inline var Region.forcedHeight: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        minHeight = value.toDouble()
        prefHeight = value.toDouble()
        maxHeight = value.toDouble()
    }

inline var FlowPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }

inline var GridPane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }

inline var TilePane.gap: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        vgap = value
        hgap = value
    }