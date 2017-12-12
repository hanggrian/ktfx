@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.animations

import javafx.animation.*
import javafx.scene.Node
import javafx.scene.shape.Shape
import javafx.util.Duration

inline fun parallelTransitionOf(vararg animations: Animation): ParallelTransition = ParallelTransition(*animations)

inline fun sequentialTransitionOf(vararg animations: Animation): SequentialTransition = SequentialTransition().apply { children.addAll(*animations) }

@JvmOverloads
inline fun Node.fadeTransition(
        duration: Duration,
        from: Double,
        to: Double,
        noinline init: ((FadeTransition) -> Unit)? = null
): Transition = FadeTransition(duration, this).apply {
    fromValue = from
    toValue = to
    init?.invoke(this)
}

@JvmOverloads
inline fun Node.pathTransition(
        duration: Duration,
        path: Shape,
        noinline init: ((PathTransition) -> Unit)? = null
): Transition = PathTransition(duration, path, this).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Node.parallelTransition(
        vararg animations: Animation,
        noinline init: ((ParallelTransition) -> Unit)? = null
): Transition = ParallelTransition(this, *animations).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Node.sequentialTransition(
        vararg animations: Animation,
        noinline init: ((SequentialTransition) -> Unit)? = null
): Transition = SequentialTransition(this).apply {
    children.addAll(*animations)
    init?.invoke(this)
}