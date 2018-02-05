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

inline var Region.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

inline var Region.prefSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPrefSize(value, value)

inline var Region.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

inline var Region.size: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        minSize = value
        prefSize = value
        maxSize = value
    }

inline var Region.width: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        minWidth = value
        prefWidth = value
        maxWidth = value
    }

inline var Region.height: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        minHeight = value
        prefHeight = value
        maxHeight = value
    }

@JvmOverloads
inline fun Region.setPadding(
        top: Double = padding.top,
        right: Double = padding.right,
        bottom: Double = padding.bottom,
        left: Double = padding.left
) = setPadding(Insets(top, right, bottom, left))

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