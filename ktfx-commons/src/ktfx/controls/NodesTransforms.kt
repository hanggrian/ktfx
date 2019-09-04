@file:JvmMultifileClass
@file:JvmName("NodesKt")
@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package ktfx.controls

import javafx.geometry.Point3D
import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.MatrixType
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Transform
import javafx.scene.transform.Translate

fun Node.affine(): Affine =
    Affine().also { transforms += it }

fun Node.affine(transform: Transform): Affine =
    Affine(transform).also { transforms += it }

fun Node.affine(
    mxx: Number,
    mxy: Number,
    tx: Number,
    myx: Number,
    myy: Number,
    ty: Number
): Affine = Affine(mxx.toDouble(), mxy.toDouble(), tx.toDouble(), myx.toDouble(), myy.toDouble(), ty.toDouble())
    .also { transforms += it }

fun Node.affine(
    mxx: Number,
    mxy: Number,
    mxz: Number,
    tx: Number,
    myx: Number,
    myy: Number,
    myz: Number,
    ty: Number,
    mzx: Number,
    mzy: Number,
    mzz: Number,
    tz: Number
): Affine = Affine(
    mxx.toDouble(),
    mxy.toDouble(),
    mxz.toDouble(),
    tx.toDouble(),
    myx.toDouble(),
    myy.toDouble(),
    myz.toDouble(),
    ty.toDouble(),
    mzx.toDouble(),
    mzy.toDouble(),
    mzz.toDouble(),
    tz.toDouble()
).also { transforms += it }

fun Node.affine(matrix: DoubleArray, type: MatrixType, offset: Int): Affine =
    Affine(matrix, type, offset).also { transforms += it }

fun Node.rotate(): Rotate =
    Rotate().also { transforms += it }

fun Node.rotate(angle: Number): Rotate =
    Rotate(angle.toDouble()).also { transforms += it }

fun Node.rotate(angle: Number, axis: Point3D): Rotate =
    Rotate(angle.toDouble(), axis).also { transforms += it }

fun Node.rotate(angle: Number, pivotX: Number, pivotY: Number): Rotate =
    Rotate(angle.toDouble(), pivotX.toDouble(), pivotY.toDouble()).also { transforms += it }

fun Node.rotate(angle: Number, pivotX: Number, pivotY: Number, pivotZ: Number): Rotate =
    Rotate(angle.toDouble(), pivotX.toDouble(), pivotY.toDouble(), pivotZ.toDouble()).also { transforms += it }

fun Node.rotate(angle: Number, pivotX: Number, pivotY: Number, pivotZ: Number, axis: Point3D): Rotate =
    Rotate(angle.toDouble(), pivotX.toDouble(), pivotY.toDouble(), pivotZ.toDouble(), axis).also { transforms += it }

fun Node.scale(x: Number, y: Number): Scale =
    Scale(x.toDouble(), y.toDouble()).also { transforms += it }

fun Node.scale(
    x: Number,
    y: Number,
    pivotX: Number,
    pivotY: Number
): Scale = Scale(x.toDouble(), y.toDouble(), pivotX.toDouble(), pivotY.toDouble()).also { transforms += it }

fun Node.scale(x: Number, y: Number, z: Number): Scale =
    Scale(x.toDouble(), y.toDouble(), z.toDouble()).also { transforms += it }

fun Node.scale(
    x: Number,
    y: Number,
    z: Number,
    pivotX: Number,
    pivotY: Number,
    pivotZ: Number
): Scale = Scale(x.toDouble(), y.toDouble(), z.toDouble(), pivotX.toDouble(), pivotY.toDouble(), pivotZ.toDouble())
    .also { transforms += it }

fun Node.shear(): Shear =
    Shear().also { transforms += it }

fun Node.shear(x: Number, y: Number): Shear =
    Shear(x.toDouble(), y.toDouble()).also { transforms += it }

fun Node.shear(x: Number, y: Number, pivotX: Number, pixotY: Number): Shear =
    Shear(x.toDouble(), y.toDouble(), pivotX.toDouble(), pixotY.toDouble()).also { transforms += it }

fun Node.translate(): Translate =
    Translate().also { transforms += it }

fun Node.translate(x: Number, y: Number): Translate =
    Translate(x.toDouble(), y.toDouble()).also { transforms += it }

fun Node.translate(x: Number, y: Number, z: Number): Translate =
    Translate(x.toDouble(), y.toDouble(), z.toDouble()).also { transforms += it }
