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

/** Create a [FadeTransition] with [configuration] block that animates this [Node]. */
inline fun Node.fadeTransition(
    duration: Duration = 400.0.ms,
    configuration: FadeTransition.() -> Unit
): FadeTransition = FadeTransition(duration, this).apply(configuration)

/** Create a [FillTransition] with [configuration] block that animates this [Shape]. */
inline fun Shape.fillTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    configuration: FillTransition.() -> Unit
): FillTransition = FillTransition(duration, this, fromValue, toValue).apply(configuration)

/** Create a [ParallelTransition] with [configuration] block that animates this [Node]. */
inline fun Node.parallelTransition(
    vararg animations: Animation,
    configuration: ParallelTransition.() -> Unit
): ParallelTransition = ParallelTransition(this, *animations).apply(configuration)

/** Create a [PathTransition] with [configuration] block that animates this [Node]. */
inline fun Node.pathTransition(
    duration: Duration = 400.0.ms,
    path: Shape? = null,
    configuration: PathTransition.() -> Unit
): PathTransition = PathTransition(duration, path, this).apply(configuration)

/** Create a [RotateTransition] with [configuration] block that animates this [Node]. */
inline fun Node.rotateTransition(
    duration: Duration = 400.0.ms,
    configuration: RotateTransition.() -> Unit
): RotateTransition = RotateTransition(duration, this).apply(configuration)

/** Create a [ScaleTransition] with [configuration] block that animates this [Node]. */
inline fun Node.scaleTransition(
    duration: Duration = 400.0.ms,
    configuration: ScaleTransition.() -> Unit
): ScaleTransition = ScaleTransition(duration, this).apply(configuration)

/** Create a [SequentialTransition] with [configuration] block that animates this [Node]. */
inline fun Node.sequentialTransition(
    vararg animations: Animation,
    configuration: SequentialTransition.() -> Unit
): SequentialTransition = SequentialTransition(this, *animations).apply(configuration)

/** Create a [StrokeTransition] with [configuration] block that animates this [Shape]. */
inline fun Shape.strokeTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    configuration: StrokeTransition.() -> Unit
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue).apply(configuration)

/** Create a [TranslateTransition] with [configuration] block that animates this [Node]. */
inline fun Node.translateTransition(
    duration: Duration = 400.0.ms,
    configuration: TranslateTransition.() -> Unit
): TranslateTransition = TranslateTransition(duration, this).apply(configuration)
