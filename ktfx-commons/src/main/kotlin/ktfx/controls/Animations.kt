@file:OptIn(ExperimentalContracts::class)

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
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Plays a [FadeTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Node.fadeTransition(
    duration: Duration = 400.0.ms,
    configuration: FadeTransition.() -> Unit,
): FadeTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return FadeTransition(duration, this).apply {
        configuration()
        play()
    }
}

/**
 * Plays a [FillTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Shape.fillTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    configuration: FillTransition.() -> Unit,
): FillTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return FillTransition(duration, this, fromValue, toValue).apply {
        configuration()
        play()
    }
}

/**
 * Plays a [PathTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Node.pathTransition(
    duration: Duration = 400.0.ms,
    path: Shape? = null,
    configuration: PathTransition.() -> Unit,
): PathTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PathTransition(duration, path, this).apply {
        configuration()
        play()
    }
}

/**
 * Plays a [RotateTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Node.rotateTransition(
    duration: Duration = 400.0.ms,
    configuration: RotateTransition.() -> Unit,
): RotateTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return RotateTransition(duration, this).apply {
        configuration()
        play()
    }
}

/**
 * Plays a [ScaleTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Node.scaleTransition(
    duration: Duration = 400.0.ms,
    configuration: ScaleTransition.() -> Unit,
): ScaleTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ScaleTransition(duration, this).apply {
        configuration()
        play()
    }
}

/**
 * Plays a [StrokeTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Shape.strokeTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    configuration: StrokeTransition.() -> Unit,
): StrokeTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return StrokeTransition(duration, this, fromValue, toValue).apply {
        configuration()
        play()
    }
}

/**
 * Plays a [TranslateTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
public inline fun Node.translateTransition(
    duration: Duration = 400.0.ms,
    configuration: TranslateTransition.() -> Unit,
): TranslateTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return TranslateTransition(duration, this).apply {
        configuration()
        play()
    }
}

/**
 * Creates a [ParallelTransition] for this node.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
public inline fun Node.parallelTransition(
    configuration: AnimationScope<Node>.() -> Unit,
): ParallelTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ParallelTransition(this, *AnimationScope(this).apply(configuration).build())
}

/**
 * Creates a [ParallelTransition] for this shape.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
public inline fun Shape.shapeParallelTransition(
    configuration: ShapeAnimationScope.() -> Unit,
): ParallelTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ParallelTransition(this, *ShapeAnimationScope(this).apply(configuration).build())
}

/**
 * Creates a [SequentialTransition] for this node.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
public inline fun Node.sequentialTransition(
    configuration: AnimationScope<Node>.() -> Unit,
): SequentialTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return SequentialTransition(this, *AnimationScope(this).apply(configuration).build())
}

/**
 * Creates a [SequentialTransition] for this shape.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
public inline fun Shape.shapeSequentialTransition(
    configuration: ShapeAnimationScope.() -> Unit,
): SequentialTransition {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return SequentialTransition(this, *ShapeAnimationScope(this).apply(configuration).build())
}

/** Shape animations configurator interface for [ParallelTransition] and [SequentialTransition]. */
public class ShapeAnimationScope(node: Shape) : AnimationScope<Shape>(node) {
    /**
     * Append a [FillTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun fill(
        duration: Duration = 400.0.ms,
        fromValue: Color? = null,
        toValue: Color? = null,
        configuration: FillTransition.() -> Unit,
    ): FillTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return FillTransition(duration, node, fromValue, toValue).also {
            it.configuration()
            animations += it
        }
    }

    /**
     * Append a [StrokeTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun stroke(
        duration: Duration = 400.0.ms,
        fromValue: Color? = null,
        toValue: Color? = null,
        configuration: StrokeTransition.() -> Unit,
    ): StrokeTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return StrokeTransition(duration, node, fromValue, toValue).also {
            it.configuration()
            animations += it
        }
    }
}

/**
 * Node animations configurator interface for [ParallelTransition] and [SequentialTransition].
 *
 * @property node node that the animations belong to.
 * @property animations collection of animations within this scope.
 */
public open class AnimationScope<T : Node>(public val node: T) {
    public val animations: MutableList<Animation> = mutableListOf()

    /**
     * Append a [FadeTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun fade(
        duration: Duration = 400.0.ms,
        configuration: FadeTransition.() -> Unit,
    ): FadeTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return FadeTransition(duration, node).also {
            it.configuration()
            animations += it
        }
    }

    /**
     * Append a [PathTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun path(
        duration: Duration = 400.0.ms,
        path: Shape? = null,
        configuration: PathTransition.() -> Unit,
    ): PathTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return PathTransition(duration, path, node).also {
            it.configuration()
            animations += it
        }
    }

    /**
     * Append a [RotateTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun rotate(
        duration: Duration = 400.0.ms,
        configuration: RotateTransition.() -> Unit,
    ): RotateTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return RotateTransition(duration, node).also {
            it.configuration()
            animations += it
        }
    }

    /**
     * Append a [ScaleTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun scale(
        duration: Duration = 400.0.ms,
        configuration: ScaleTransition.() -> Unit,
    ): ScaleTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return ScaleTransition(duration, node).also {
            it.configuration()
            animations += it
        }
    }

    /**
     * Append a [TranslateTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    public inline fun translate(
        duration: Duration = 400.0.ms,
        configuration: TranslateTransition.() -> Unit,
    ): TranslateTransition {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return TranslateTransition(duration, node).also {
            it.configuration()
            animations += it
        }
    }

    /** Return array of animations based on current configuration. */
    public fun build(): Array<Animation> = animations.toTypedArray()
}
