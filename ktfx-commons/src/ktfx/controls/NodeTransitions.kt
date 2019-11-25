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
import ktfx.util.millis

/** Construct a [FadeTransition] that animates this [Node]. */
fun Node.fadeTransition(duration: Duration = 400.0.millis): FadeTransition =
    FadeTransition(duration, this)

/** Construct a [FillTransition] that animates this [Shape]. */
fun Shape.fillTransition(
    duration: Duration = 400.0.millis,
    fromValue: Color? = null,
    toValue: Color? = null
): FillTransition = FillTransition(duration, this, fromValue, toValue)

/** Construct a [ParallelTransition] that animates this [Node]. */
fun Node.parallelTransition(vararg animations: Animation): ParallelTransition =
    ParallelTransition(this, *animations)

/** Construct a [PathTransition] that animates this [Node]. */
fun Node.pathTransition(duration: Duration = 400.0.millis, path: Shape? = null): PathTransition =
    PathTransition(duration, path, this)

/** Construct a [RotateTransition] that animates this [Node]. */
fun Node.rotateTransition(duration: Duration = 400.0.millis): RotateTransition = RotateTransition(duration, this)

/** Construct a [ScaleTransition] that animates this [Node]. */
fun Node.scaleTransition(duration: Duration = 400.0.millis): ScaleTransition = ScaleTransition(duration, this)

/** Construct a [SequentialTransition] that animates this [Node]. */
fun Node.sequentialTransition(vararg animations: Animation): SequentialTransition =
    SequentialTransition(this, *animations)

/** Construct a [StrokeTransition] that animates this [Shape]. */
fun Shape.strokeTransition(
    duration: Duration = 400.0.millis,
    fromValue: Color? = null,
    toValue: Color? = null
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue)

/** Construct a [TranslateTransition] that animates this [Node]. */
fun Node.translateTransition(duration: Duration = 400.0.millis): TranslateTransition =
    TranslateTransition(duration, this)
