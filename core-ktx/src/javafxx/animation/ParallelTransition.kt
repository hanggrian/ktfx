@file:Suppress("NOTHING_TO_INLINE")

package javafxx.animation

import javafx.animation.Animation
import javafx.animation.ParallelTransition
import javafx.scene.Node

/** Construct a [ParallelTransition] that animates this [Node]. */
inline fun Node?.parallelTransition(
    vararg animations: Animation
): ParallelTransition = ParallelTransition(this, *animations)