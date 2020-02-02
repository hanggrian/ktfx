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

/** Construct a [FadeTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.fadeTransition(
    duration: Duration = 400.0.ms,
    transitionAction: FadeTransition.() -> Unit
): FadeTransition = FadeTransition(duration, this).apply(transitionAction)

/** Construct a [FillTransition] with [transitionAction] that animates this [Shape]. */
inline fun Shape.fillTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    transitionAction: FillTransition.() -> Unit
): FillTransition = FillTransition(duration, this, fromValue, toValue).apply(transitionAction)

/** Construct a [ParallelTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.parallelTransition(
    vararg animations: Animation,
    transitionAction: ParallelTransition.() -> Unit
): ParallelTransition = ParallelTransition(this, *animations).apply(transitionAction)

/** Construct a [PathTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.pathTransition(
    duration: Duration = 400.0.ms,
    path: Shape? = null,
    transitionAction: PathTransition.() -> Unit
): PathTransition = PathTransition(duration, path, this).apply(transitionAction)

/** Construct a [RotateTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.rotateTransition(
    duration: Duration = 400.0.ms,
    transitionAction: RotateTransition.() -> Unit
): RotateTransition = RotateTransition(duration, this).apply(transitionAction)

/** Construct a [ScaleTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.scaleTransition(
    duration: Duration = 400.0.ms,
    transitionAction: ScaleTransition.() -> Unit
): ScaleTransition = ScaleTransition(duration, this).apply(transitionAction)

/** Construct a [SequentialTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.sequentialTransition(
    vararg animations: Animation,
    transitionAction: SequentialTransition.() -> Unit
): SequentialTransition = SequentialTransition(this, *animations).apply(transitionAction)

/** Construct a [StrokeTransition] with [transitionAction] that animates this [Shape]. */
inline fun Shape.strokeTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    transitionAction: StrokeTransition.() -> Unit
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue).apply(transitionAction)

/** Construct a [TranslateTransition] with [transitionAction] that animates this [Node]. */
inline fun Node.translateTransition(
    duration: Duration = 400.0.ms,
    transitionAction: TranslateTransition.() -> Unit
): TranslateTransition = TranslateTransition(duration, this).apply(transitionAction)
