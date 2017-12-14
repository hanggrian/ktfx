@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.geometry.Insets
import javafx.geometry.NodeOrientation
import javafx.geometry.Point3D
import javafx.scene.*
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect
import javafx.scene.layout.Pane
import javafx.scene.layout.Region
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint

interface _Node<out N : Node> {
    val node: N

    fun data(value: Any) = node.setUserData(value)
    fun id(value: String) = node.setId(value)
    fun style(value: String) = node.setStyle(value)
    fun visible(value: Boolean) = node.setVisible(value)
    fun cursor(value: Cursor) = node.setCursor(value)
    fun opacity(value: Number) = node.setOpacity(value.toDouble())
    fun clip(value: Node) = node.setClip(value)
    fun blend(value: BlendMode) = node.setBlendMode(value)
    fun cache(value: Boolean) = node.setCache(value)
    fun cacheHint(value: CacheHint) = node.setCacheHint(value)
    fun effect(value: Effect) = node.setEffect(value)
    fun disable(value: Boolean) = node.setDisable(value)
    fun pickOnBounds(value: Boolean) = node.setPickOnBounds(value)
    fun managed(value: Boolean) = node.setManaged(value)

    fun layoutX(value: Number) = node.setLayoutX(value.toDouble())
    fun layoutY(value: Number) = node.setLayoutY(value.toDouble())
    fun layout(x: Number, y: Number) {
        layoutX(x)
        layoutY(y)
    }

    fun translateX(value: Number) = node.setTranslateX(value.toDouble())
    fun translateY(value: Number) = node.setTranslateY(value.toDouble())
    fun translateZ(value: Number) = node.setTranslateZ(value.toDouble())
    fun translate(x: Number, y: Number, z: Number) {
        translateX(x)
        translateY(y)
        translateZ(z)
    }

    fun scaleX(value: Number) = node.setScaleX(value.toDouble())
    fun scaleY(value: Number) = node.setScaleY(value.toDouble())
    fun scaleZ(value: Number) = node.setScaleZ(value.toDouble())
    fun scale(x: Number, y: Number, z: Number) {
        scaleX(x)
        scaleY(y)
        scaleZ(z)
    }

    fun rotate(value: Number) = node.setRotate(value.toDouble())
    fun rotationAxis(value: Point3D) = node.setRotationAxis(value)
    fun nodeOrientation(value: NodeOrientation) = node.setNodeOrientation(value)
    fun mouseTransparent(value: Boolean) = node.setMouseTransparent(value)
}

interface _Region<out N : Region> : _Node<N> {
    fun minWidth(value: Number) = node.setMinWidth(value.toDouble())
    fun minHeight(value: Number) = node.setMinHeight(value.toDouble())
    fun minSize(width: Number, height: Number) = node.setMinSize(width.toDouble(), height.toDouble())
    fun minSize(value: Number) = minSize(value, value)

    fun prefWidth(value: Number) = node.setPrefWidth(value.toDouble())
    fun prefHeight(value: Number) = node.setPrefHeight(value.toDouble())
    fun prefSize(width: Number, height: Number) = node.setPrefSize(width.toDouble(), height.toDouble())
    fun prefSize(value: Number) = prefSize(value, value)

    fun maxWidth(value: Number) = node.setMaxWidth(value.toDouble())
    fun maxHeight(value: Number) = node.setMaxHeight(value.toDouble())
    fun maxSize(width: Number, height: Number) = node.setMaxSize(width.toDouble(), height.toDouble())
    fun maxSize(value: Number) = maxSize(value, value)

    fun forceWidth(value: Number) {
        minWidth(value)
        prefWidth(value)
        maxWidth(value)
    }

    fun forceHeight(value: Number) {
        minHeight(value)
        prefHeight(value)
        maxHeight(value)
    }

    fun forceSize(width: Number, height: Number) {
        forceWidth(width)
        forceHeight(height)
    }

    fun forceSize(value: Number) = forceSize(value, value)

    fun padding(value: Insets) = node.setPadding(value)
    fun padding(value: Number) = padding(Insets(value.toDouble()))
    fun paddingTop(value: Number) = node.padding.let { padding(Insets(value.toDouble(), it.right, it.bottom, it.left)) }
    fun paddingRight(value: Number) = node.padding.let { padding(Insets(it.top, value.toDouble(), it.bottom, it.left)) }
    fun paddingBottom(value: Number) = node.padding.let { padding(Insets(it.top, it.right, value.toDouble(), it.left)) }
    fun paddingLeft(value: Number) = node.padding.let { padding(Insets(it.top, it.right, it.bottom, value.toDouble())) }
}

interface _Pane : _Region<Pane> {
    fun <N : Node> N.add(): N = apply { node.children.add(this) }
    fun <N : Node> N.clearConstraints(): N
}

inline fun Parent.toScene(): Scene = Scene(this)

@JvmOverloads
inline fun Parent.toScene(width: Double, height: Double, fill: Paint = WHITE): Scene = Scene(this, width, height, fill)

inline fun Parent.toScene(fill: Paint): Scene = Scene(this, fill)