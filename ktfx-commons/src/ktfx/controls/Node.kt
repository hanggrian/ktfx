@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package ktfx.controls

import javafx.animation.Animation
import javafx.animation.FadeTransition
import javafx.animation.FillTransition
import javafx.animation.ParallelTransition
import javafx.animation.PathTransition
import javafx.animation.RotateTransition
import javafx.animation.ScaleTransition
import javafx.animation.SequentialTransition
import javafx.animation.StrokeTransition
import javafx.animation.TranslateTransition
import javafx.geometry.Point3D
import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import javafx.scene.transform.Affine
import javafx.scene.transform.MatrixType
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Shear
import javafx.scene.transform.Transform
import javafx.scene.transform.Translate
import javafx.util.Duration
import ktfx.internal.KtfxInternals

/** Alias of [Node.lookup] with non-null return and specified type. */
@Suppress("UNCHECKED_CAST")
inline fun <T : Node> Node.find(selector: String): T = lookup(selector) as T

/** Take a screenshot of this [Node] returning image it wrote. */
inline fun Node.snapshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null
): WritableImage = snapshot(params, image)

/** Wraps this child in pane, if not already. */
inline fun Node.asPane(): Pane = KtfxInternals.asPane(this)

/** Construct a [FadeTransition] that animates this [Node]. */
inline fun Node?.fadeTransition(
    duration: Duration = Duration.millis(400.0)
): FadeTransition = FadeTransition(duration, this)

/** Construct a [FillTransition] that animates this [Shape]. */
inline fun Shape?.fillTransition(
    duration: Duration = Duration.millis(400.0),
    fromValue: Color? = null,
    toValue: Color? = null
): FillTransition = FillTransition(duration, this, fromValue, toValue)

/** Construct a [ParallelTransition] that animates this [Node]. */
inline fun Node?.parallelTransition(
    vararg animations: Animation
): ParallelTransition = ParallelTransition(this, *animations)

/** Construct a [PathTransition] that animates this [Node]. */
inline fun Node?.pathTransition(
    duration: Duration = Duration.millis(400.0),
    path: Shape? = null
): PathTransition = PathTransition(duration, path, this)

/** Construct a [RotateTransition] that animates this [Node]. */
inline fun Node?.rotateTransition(
    duration: Duration = Duration.millis(400.0)
): RotateTransition = RotateTransition(duration, this)

/** Construct a [ScaleTransition] that animates this [Node]. */
inline fun Node?.scaleTransition(
    duration: Duration = Duration.millis(400.0)
): ScaleTransition = ScaleTransition(duration, this)

/** Construct a [SequentialTransition] that animates this [Node]. */
inline fun Node?.sequentialTransition(
    vararg animations: Animation
): SequentialTransition = SequentialTransition(this, *animations)

/** Construct a [StrokeTransition] that animates this [Shape]. */
inline fun Shape?.strokeTransition(
    duration: Duration = Duration.millis(400.0),
    fromValue: Color? = null,
    toValue: Color? = null
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue)

/** Construct a [TranslateTransition] that animates this [Node]. */
inline fun Node?.translateTransition(
    duration: Duration = Duration.millis(400.0)
): TranslateTransition = TranslateTransition(duration, this)

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

inline fun Node.rotate(): Rotate = Rotate().also { transforms += it }

inline fun Node.rotate(angle: Double): Rotate = Rotate(angle).also { transforms += it }

inline fun Node.rotate(angle: Double, axis: Point3D): Rotate = Rotate(angle, axis).also { transforms += it }

inline fun Node.rotate(angle: Double, pivotX: Double, pivotY: Double): Rotate =
    Rotate(angle, pivotX, pivotY).also { transforms += it }

inline fun Node.rotate(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double): Rotate =
    Rotate(angle, pivotX, pivotY, pivotZ).also { transforms += it }

inline fun Node.rotate(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double, axis: Point3D): Rotate =
    Rotate(angle, pivotX, pivotY, pivotZ, axis).also { transforms += it }

inline fun Node.scale(x: Double, y: Double): Scale = Scale(x, y).also { transforms += it }

inline fun Node.scale(
    x: Double,
    y: Double,
    pivotX: Double,
    pivotY: Double
): Scale = Scale(x, y, pivotX, pivotY).also { transforms += it }

inline fun Node.scale(x: Double, y: Double, z: Double): Scale = Scale(x, y, z).also { transforms += it }

inline fun Node.scale(
    x: Double,
    y: Double,
    z: Double,
    pivotX: Double,
    pivotY: Double,
    pivotZ: Double
): Scale = Scale(x, y, z, pivotX, pivotY, pivotZ).also { transforms += it }

inline fun Node.shear(): Shear = Shear().also { transforms += it }

inline fun Node.shear(x: Double, y: Double): Shear = Shear(x, y).also { transforms += it }

inline fun Node.shear(x: Double, y: Double, pivotX: Double, pixotY: Double): Shear =
    Shear(x, y, pivotX, pixotY).also { transforms += it }

inline fun Node.translate(): Translate = Translate().also { transforms += it }

inline fun Node.translate(x: Double, y: Double): Translate = Translate(x, y).also { transforms += it }

inline fun Node.translate(x: Double, y: Double, z: Double): Translate = Translate(x, y, z).also { transforms += it }