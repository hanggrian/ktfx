@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.Node
import javafx.scene.transform.Affine
import javafx.scene.transform.MatrixType
import javafx.scene.transform.Transform

inline fun Node.affine(): Affine = Affine().also { transforms += it }

inline fun Node.affine(transform: Transform): Affine = Affine(transform).also { transforms += it }

inline fun Node.affine(
    mxx: Double,
    mxy: Double,
    tx: Double,
    myx: Double,
    myy: Double,
    ty: Double
): Affine = Affine(mxx, mxy, tx, myx, myy, ty).also { transforms += it }

inline fun Node.affine(
    mxx: Double,
    mxy: Double,
    mxz: Double,
    tx: Double,
    myx: Double,
    myy: Double,
    myz: Double,
    ty: Double,
    mzx: Double,
    mzy: Double,
    mzz: Double,
    tz: Double
): Affine = Affine(mxx, mxy, mxz, tx, myx, myy, myz, ty, mzx, mzy, mzz, tz).also { transforms += it }

inline fun Node.affine(matrix: DoubleArray, type: MatrixType, offset: Int): Affine =
    Affine(matrix, type, offset).also { transforms += it }