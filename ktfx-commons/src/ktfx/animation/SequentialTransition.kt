@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.Animation
import javafx.animation.SequentialTransition
import javafx.scene.Node

/** Construct a [SequentialTransition] that animates this [Node]. */
inline fun Node?.sequentialTransition(
    vararg animations: Animation
): SequentialTransition = SequentialTransition(this, *animations)