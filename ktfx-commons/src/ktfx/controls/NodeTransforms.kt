@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.geometry.Point3D
import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Translate

/** Add [Affine] transformation, returning the transformation added. */
fun Node.affine(): Affine = Affine().also { transforms += it }

/** Add [Affine] transformation with [builderAction], returning the transformation added. */
inline fun Node.affine(builderAction: Affine.() -> Unit): Affine = affine().apply(builderAction)

/** Add [Rotate] transformation returning the transformation added. */
fun Node.rotate(
    angle: Double = 0.0,
    pivotX: Double = 0.0,
    pivotY: Double = 0.0,
    pivotZ: Double = 0.0,
    axis: Point3D = Rotate.Z_AXIS
): Rotate = Rotate(angle, pivotX, pivotY, pivotZ, axis).also { transforms += it }

/** Add [Rotate] transformation with [builderAction], returning the transformation added. */
inline fun Node.rotate(
    angle: Double = 0.0,
    pivotX: Double = 0.0,
    pivotY: Double = 0.0,
    pivotZ: Double = 0.0,
    axis: Point3D = Rotate.Z_AXIS,
    builderAction: Rotate.() -> Unit
): Rotate = rotate(angle, pivotX, pivotY, pivotZ, axis).apply(builderAction)

/** Add [Scale] transformation returning the transformation added. */
fun Node.scale(
    x: Double = 1.0,
    y: Double = 1.0,
    z: Double = 1.0,
    pivotX: Double = 0.0,
    pivotY: Double = 0.0,
    pivotZ: Double = 0.0
): Scale = Scale(x, y, z, pivotX, pivotY, pivotZ).also { transforms += it }

/** Add [Scale] transformation with [builderAction], returning the transformation added. */
inline fun Node.scale(
    x: Double = 1.0,
    y: Double = 1.0,
    z: Double = 1.0,
    pivotX: Double = 0.0,
    pivotY: Double = 0.0,
    pivotZ: Double = 0.0,
    builderAction: Scale.() -> Unit
): Scale = scale(x, y, z, pivotX, pivotY, pivotZ).apply(builderAction)

/** Add [Shear] transformation returning the transformation added. */
fun Node.shear(x: Double = 0.0, y: Double = 0.0, pivotX: Double = 0.0, pivotY: Double = 0.0): Shear =
    Shear(x, y, pivotX, pivotY).also { transforms += it }

/** Add [Shear] transformation with [builderAction], returning the transformation added. */
inline fun Node.shear(
    x: Double = 0.0,
    y: Double = 0.0,
    pivotX: Double = 0.0,
    pivotY: Double = 0.0,
    builderAction: Shear.() -> Unit
): Shear = shear(x, y, pivotX, pivotY).apply(builderAction)

/** Add [Translate] transformation returning the transformation added. */
fun Node.translate(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): Translate =
    Translate(x, y, z).also { transforms += it }

/** Add [Translate] transformation with [builderAction], returning the transformation added. */
inline fun Node.translate(
    x: Double = 0.0,
    y: Double = 0.0,
    z: Double = 0.0,
    builderAction: Translate.() -> Unit
): Translate = translate(x, y, z).apply(builderAction)
