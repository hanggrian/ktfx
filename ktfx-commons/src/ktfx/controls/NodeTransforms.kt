@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Translate

/** Add [Affine] transformation, returning the transformation added. */
fun Node.affine(): Affine =
    Affine().also { transforms += it }

/** Add [Affine] transformation with [builderAction], returning the transformation added. */
inline fun Node.affine(builderAction: Affine.() -> Unit): Affine =
    affine().apply(builderAction)

/** Add [Rotate] transformation returning the transformation added. */
fun Node.rotate(): Rotate =
    Rotate().also { transforms += it }

/** Add [Rotate] transformation with [builderAction], returning the transformation added. */
inline fun Node.rotate(builderAction: Rotate.() -> Unit): Rotate =
    rotate().apply(builderAction)

/** Add [Scale] transformation returning the transformation added. */
fun Node.scale(): Scale =
    Scale().also { transforms += it }

/** Add [Scale] transformation with [builderAction], returning the transformation added. */
inline fun Node.scale(builderAction: Scale.() -> Unit): Scale =
    scale().apply(builderAction)

/** Add [Shear] transformation returning the transformation added. */
fun Node.shear(): Shear =
    Shear().also { transforms += it }

/** Add [Shear] transformation with [builderAction], returning the transformation added. */
inline fun Node.shear(builderAction: Shear.() -> Unit): Shear =
    shear().apply(builderAction)

/** Add [Translate] transformation returning the transformation added. */
fun Node.translate(): Translate =
    Translate().also { transforms += it }

/** Add [Translate] transformation with [builderAction], returning the transformation added. */
inline fun Node.translate(builderAction: Translate.() -> Unit): Translate =
    translate().apply(builderAction)
