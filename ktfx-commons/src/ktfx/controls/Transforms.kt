package ktfx.controls

import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Translate

/** Add [Affine] transformation with [configuration] block to this [Node], returning the transformation added. */
inline fun Node.affineTransform(configuration: Affine.() -> Unit): Affine {
    val transform = Affine()
    transform.configuration()
    transforms += transform
    return transform
}

/** Add [Rotate] transformation with [configuration] block to this [Node], returning the transformation added. */
inline fun Node.rotateTransform(configuration: Rotate.() -> Unit): Rotate {
    val transform = Rotate()
    transform.configuration()
    transforms += transform
    return transform
}

/** Add [Scale] transformation with [configuration] block to this [Node], returning the transformation added. */
inline fun Node.scaleTransform(configuration: Scale.() -> Unit): Scale {
    val transform = Scale()
    transform.configuration()
    transforms += transform
    return transform
}

/** Add [Shear] transformation with [configuration] block to this [Node], returning the transformation added. */
inline fun Node.shearTransform(configuration: Shear.() -> Unit): Shear {
    val transform = Shear()
    transform.configuration()
    transforms += transform
    return transform
}

/** Add [Translate] transformation with [configuration] block to this [Node], returning the transformation added. */
inline fun Node.translateTransform(configuration: Translate.() -> Unit): Translate {
    val transform = Translate()
    transform.configuration()
    transforms += transform
    return transform
}
