@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Translate

/** Add [Affine] transformation with [transformAction] to this node, returning the transformation added. */
inline fun Node.affineTransform(transformAction: Affine.() -> Unit): Affine = Affine().also {
    it.transformAction()
    transforms += it
}

/** Add [Rotate] transformation with [transformAction] to this node, returning the transformation added. */
inline fun Node.rotateTransform(transformAction: Rotate.() -> Unit): Rotate = Rotate().also {
    it.transformAction()
    transforms += it
}

/** Add [Scale] transformation with [transformAction] to this node, returning the transformation added. */
inline fun Node.scaleTransform(transformAction: Scale.() -> Unit): Scale = Scale().also {
    it.transformAction()
    transforms += it
}

/** Add [Shear] transformation with [transformAction] to this node, returning the transformation added. */
inline fun Node.shearTransform(transformAction: Shear.() -> Unit): Shear = Shear().also {
    it.transformAction()
    transforms += it
}

/** Add [Translate] transformation with [transformAction] to this node, returning the transformation added. */
inline fun Node.translateTransform(transformAction: Translate.() -> Unit): Translate = Translate().also {
    it.transformAction()
    transforms += it
}
