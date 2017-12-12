package kotfx.layouts.controls

import javafx.geometry.Insets
import javafx.scene.layout.Region
import kotfx.internal.Instanced

interface _Region<out T : Region> : Instanced<T> {

    fun minWidth(width: Number) = instance.setMinWidth(width.toDouble())
    fun minHeight(height: Number) = instance.setMinHeight(height.toDouble())
    fun minSize(width: Number, height: Number) = instance.setMinSize(width.toDouble(), height.toDouble())
    fun minSize(size: Number) = minSize(size, size)

    fun prefWidth(width: Number) = instance.setPrefWidth(width.toDouble())
    fun prefHeight(height: Number) = instance.setPrefHeight(height.toDouble())
    fun prefSize(width: Number, height: Number) = instance.setPrefSize(width.toDouble(), height.toDouble())
    fun prefSize(size: Number) = prefSize(size, size)

    fun maxWidth(width: Number) = instance.setMaxWidth(width.toDouble())
    fun maxHeight(height: Number) = instance.setMaxHeight(height.toDouble())
    fun maxSize(width: Number, height: Number) = instance.setMaxSize(width.toDouble(), height.toDouble())
    fun maxSize(size: Number) = maxSize(size, size)

    fun forceWidth(width: Number) {
        minWidth(width)
        prefWidth(width)
        maxWidth(width)
    }

    fun forceHeight(width: Number) {
        minHeight(width)
        prefHeight(width)
        maxHeight(width)
    }

    fun forceSize(width: Number, height: Number) {
        forceWidth(width)
        forceHeight(height)
    }

    fun forceSize(size: Number) = forceSize(size, size)

    fun padding(padding: Insets) = instance.setPadding(padding)
    fun padding(padding: Number) = padding(Insets(padding.toDouble()))
    fun paddingTop(padding: Number) = instance.padding.let { padding(Insets(padding.toDouble(), it.right, it.bottom, it.left)) }
    fun paddingRight(padding: Number) = instance.padding.let { padding(Insets(it.top, padding.toDouble(), it.bottom, it.left)) }
    fun paddingBottom(padding: Number) = instance.padding.let { padding(Insets(it.top, it.right, padding.toDouble(), it.left)) }
    fun paddingLeft(padding: Number) = instance.padding.let { padding(Insets(it.top, it.right, it.bottom, padding.toDouble())) }
}