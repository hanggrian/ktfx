@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.geometry.Insets
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.TilePane

@JvmOverloads
inline fun Region.minSize(width: Number, height: Number = width) = setMinSize(width.toDouble(), height.toDouble())

@JvmOverloads
inline fun Region.prefSize(width: Number, height: Number = width) = setPrefSize(width.toDouble(), height.toDouble())

@JvmOverloads
inline fun Region.maxSize(width: Number, height: Number = width) = setMaxSize(width.toDouble(), height.toDouble())

@JvmOverloads
inline fun Region.size(width: Number, height: Number = width) {
    minSize(width, height)
    prefSize(width, height)
    maxSize(width, height)
}

@JvmOverloads
inline fun Region.padding(
        top: Number = padding.top,
        right: Number = padding.right,
        bottom: Number = padding.bottom,
        left: Number = padding.left
) = setPadding(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

@JvmOverloads
inline fun FlowPane.gap(vertical: Number, horizontal: Number = vertical) {
    vgap = vertical.toDouble()
    hgap = horizontal.toDouble()
}

@JvmOverloads
inline fun GridPane.gap(vertical: Number, horizontal: Number = vertical) {
    vgap = vertical.toDouble()
    hgap = horizontal.toDouble()
}

@JvmOverloads
inline fun TilePane.gap(vertical: Number, horizontal: Number = vertical) {
    vgap = vertical.toDouble()
    hgap = horizontal.toDouble()
}