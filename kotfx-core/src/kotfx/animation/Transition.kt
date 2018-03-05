@file:Suppress("NOTHING_TO_INLINE")

package kotfx.animation

import javafx.animation.Animation
import javafx.animation.FadeTransition
import javafx.animation.ParallelTransition
import javafx.animation.PathTransition
import javafx.animation.SequentialTransition
import javafx.animation.Transition
import javafx.scene.Node
import javafx.scene.shape.Shape
import javafx.util.Duration

inline fun parallelTransitionOf(vararg animations: Animation): ParallelTransition = ParallelTransition(*animations)

inline fun sequentialTransitionOf(vararg animations: Animation): SequentialTransition = SequentialTransition().apply { children.addAll(*animations) }

inline fun Node.fadeTransition(
    duration: Duration,
    from: Double,
    to: Double,
    noinline init: (FadeTransition.() -> Unit)? = null
): Transition = FadeTransition(duration, this).apply {
    fromValue = from
    toValue = to
    init?.invoke(this)
}

inline fun Node.pathTransition(
    duration: Duration,
    path: Shape,
    noinline init: (PathTransition.() -> Unit)? = null
): Transition = PathTransition(duration, path, this).apply {
    init?.invoke(this)
}

inline fun Node.parallelTransition(
    vararg animations: Animation,
    noinline init: (ParallelTransition.() -> Unit)? = null
): Transition = ParallelTransition(this, *animations).apply {
    init?.invoke(this)
}

inline fun Node.sequentialTransition(
    vararg animations: Animation,
    noinline init: (SequentialTransition.() -> Unit)? = null
): Transition = SequentialTransition(this).apply {
    children.addAll(*animations)
    init?.invoke(this)
}