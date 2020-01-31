@file:JvmMultifileClass
@file:JvmName("NodeKt")

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
import javafx.scene.Node
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import javafx.util.Duration
import ktfx.time.ms

/** Construct a [FadeTransition] that animates this [Node]. */
fun Node.fadeTransition(duration: Duration = 400.0.ms): FadeTransition = FadeTransition(duration, this)

/** Construct a [FadeTransition] with [builderAction] that animates this [Node], . */
inline fun Node.fadeTransition(
    duration: Duration = 400.0.ms,
    builderAction: FadeTransition.() -> Unit
): FadeTransition = fadeTransition(duration).apply(builderAction)

/** Construct a [FillTransition] that animates this [Shape]. */
fun Shape.fillTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null
): FillTransition = FillTransition(duration, this, fromValue, toValue)

/** Construct a [FillTransition] with [builderAction] that animates this [Shape]. */
inline fun Shape.fillTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    builderAction: FillTransition.() -> Unit
): FillTransition = fillTransition(duration, fromValue, toValue).apply(builderAction)

/** Construct a [ParallelTransition] that animates this [Node]. */
fun Node.parallelTransition(vararg animations: Animation): ParallelTransition = ParallelTransition(this, *animations)

/** Construct a [ParallelTransition] with [builderAction] that animates this [Node]. */
inline fun Node.parallelTransition(
    vararg animations: Animation,
    builderAction: ParallelTransition.() -> Unit
): ParallelTransition = parallelTransition(*animations).apply(builderAction)

/** Construct a [PathTransition] that animates this [Node]. */
fun Node.pathTransition(duration: Duration = 400.0.ms, path: Shape? = null): PathTransition =
    PathTransition(duration, path, this)

/** Construct a [PathTransition] with [builderAction] that animates this [Node]. */
inline fun Node.pathTransition(
    duration: Duration = 400.0.ms,
    path: Shape? = null,
    builderAction: PathTransition.() -> Unit
): PathTransition = pathTransition(duration, path).apply(builderAction)

/** Construct a [RotateTransition] that animates this [Node]. */
fun Node.rotateTransition(duration: Duration = 400.0.ms): RotateTransition = RotateTransition(duration, this)

/** Construct a [RotateTransition] with [builderAction] that animates this [Node]. */
inline fun Node.rotateTransition(
    duration: Duration = 400.0.ms,
    builderAction: RotateTransition.() -> Unit
): RotateTransition = rotateTransition(duration).apply(builderAction)

/** Construct a [ScaleTransition] that animates this [Node]. */
fun Node.scaleTransition(duration: Duration = 400.0.ms): ScaleTransition = ScaleTransition(duration, this)

/** Construct a [ScaleTransition] with [builderAction] that animates this [Node]. */
inline fun Node.scaleTransition(
    duration: Duration = 400.0.ms,
    builderAction: ScaleTransition.() -> Unit
): ScaleTransition = scaleTransition(duration).apply(builderAction)

/** Construct a [SequentialTransition] that animates this [Node]. */
fun Node.sequentialTransition(vararg animations: Animation): SequentialTransition =
    SequentialTransition(this, *animations)

/** Construct a [SequentialTransition] with [builderAction] that animates this [Node]. */
inline fun Node.sequentialTransition(
    vararg animations: Animation,
    builderAction: SequentialTransition.() -> Unit
): SequentialTransition = sequentialTransition(*animations).apply(builderAction)

/** Construct a [StrokeTransition] that animates this [Shape]. */
fun Shape.strokeTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue)

/** Construct a [StrokeTransition] with [builderAction] that animates this [Shape]. */
inline fun Shape.strokeTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    builderAction: StrokeTransition.() -> Unit
): StrokeTransition = strokeTransition(duration, fromValue, toValue).apply(builderAction)

/** Construct a [TranslateTransition] that animates this [Node]. */
fun Node.translateTransition(duration: Duration = 400.0.ms): TranslateTransition =
    TranslateTransition(duration, this)

/** Construct a [TranslateTransition] with [builderAction] that animates this [Node]. */
fun Node.translateTransition(
    duration: Duration = 400.0.ms,
    builderAction: TranslateTransition.() -> Unit
): TranslateTransition = translateTransition(duration).apply(builderAction)
