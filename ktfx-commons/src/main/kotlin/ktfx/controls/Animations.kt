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

/**
 * Plays a [FadeTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Node.fadeTransition(
    duration: Duration = 400.0.ms,
    configuration: FadeTransition.() -> Unit
): FadeTransition = FadeTransition(duration, this).apply {
    configuration()
    play()
}

/**
 * Plays a [FillTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Shape.fillTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    configuration: FillTransition.() -> Unit
): FillTransition = FillTransition(duration, this, fromValue, toValue).apply {
    configuration()
    play()
}

/**
 * Plays a [PathTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Node.pathTransition(
    duration: Duration = 400.0.ms,
    path: Shape? = null,
    configuration: PathTransition.() -> Unit
): PathTransition = PathTransition(duration, path, this).apply {
    configuration()
    play()
}

/**
 * Plays a [RotateTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Node.rotateTransition(
    duration: Duration = 400.0.ms,
    configuration: RotateTransition.() -> Unit
): RotateTransition = RotateTransition(duration, this).apply {
    configuration()
    play()
}

/**
 * Plays a [ScaleTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Node.scaleTransition(
    duration: Duration = 400.0.ms,
    configuration: ScaleTransition.() -> Unit
): ScaleTransition = ScaleTransition(duration, this).apply {
    configuration()
    play()
}

/**
 * Plays a [StrokeTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Shape.strokeTransition(
    duration: Duration = 400.0.ms,
    fromValue: Color? = null,
    toValue: Color? = null,
    configuration: StrokeTransition.() -> Unit
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue).apply {
    configuration()
    play()
}

/**
 * Plays a [TranslateTransition].
 *
 * @param duration length of this animation.
 * @param configuration the configuration block that customizes animation.
 * @return the animation played.
 */
fun Node.translateTransition(
    duration: Duration = 400.0.ms,
    configuration: TranslateTransition.() -> Unit
): TranslateTransition = TranslateTransition(duration, this).apply {
    configuration()
    play()
}

/**
 * Creates a [ParallelTransition] for this node.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
fun Node.parallelTransition(
    configuration: AnimationScope.() -> Unit
): ParallelTransition = ParallelTransition(
    this,
    *object : AnimationScope {
        override val node: Node get() = this@parallelTransition
        override val animations: MutableCollection<Animation> = mutableListOf()
    }.apply(configuration).build()
)

/**
 * Creates a [ParallelTransition] for this shape.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
fun Shape.shapeParallelTransition(
    configuration: ShapeAnimationScope.() -> Unit
): ParallelTransition = ParallelTransition(
    this,
    *object : ShapeAnimationScope {
        override val node: Shape get() = this@shapeParallelTransition
        override val animations: MutableCollection<Animation> = mutableListOf()
    }.apply(configuration).build()
)

/**
 * Creates a [SequentialTransition] for this node.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
fun Node.sequentialTransition(
    configuration: AnimationScope.() -> Unit
): SequentialTransition = SequentialTransition(
    this,
    *object : AnimationScope {
        override val node: Node get() = this@sequentialTransition
        override val animations: MutableCollection<Animation> = mutableListOf()
    }.apply(configuration).build()
)

/**
 * Creates a [SequentialTransition] for this shape.
 *
 * @param configuration the configuration block that customizes animations within this animation.
 * @return the animation played.
 */
fun Shape.shapeSequentialTransition(
    configuration: ShapeAnimationScope.() -> Unit
): SequentialTransition = SequentialTransition(
    this,
    *object : ShapeAnimationScope {
        override val node: Shape get() = this@shapeSequentialTransition
        override val animations: MutableCollection<Animation> = mutableListOf()
    }.apply(configuration).build()
)

/** Shape animations configurator interface for [ParallelTransition] and [SequentialTransition]. */
interface ShapeAnimationScope : AnimationScope {
    override val node: Shape

    /**
     * Append a [FillTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun fill(
        duration: Duration = 400.0.ms,
        fromValue: Color? = null,
        toValue: Color? = null,
        configuration: FillTransition.() -> Unit
    ): FillTransition = FillTransition(duration, node, fromValue, toValue).also {
        it.configuration()
        animations += it
    }

    /**
     * Append a [StrokeTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun stroke(
        duration: Duration = 400.0.ms,
        fromValue: Color? = null,
        toValue: Color? = null,
        configuration: StrokeTransition.() -> Unit
    ): StrokeTransition = StrokeTransition(duration, node, fromValue, toValue).also {
        it.configuration()
        animations += it
    }
}

/** Node animations configurator interface for [ParallelTransition] and [SequentialTransition]. */
interface AnimationScope {
    /** Node that the animations belong to. */
    val node: Node

    /** Collection of animations within this scope. */
    val animations: MutableCollection<Animation>

    /**
     * Append a [FadeTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun fade(
        duration: Duration = 400.0.ms,
        configuration: FadeTransition.() -> Unit
    ): FadeTransition = FadeTransition(duration, node).also {
        it.configuration()
        animations += it
    }

    /**
     * Append a [PathTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun path(
        duration: Duration = 400.0.ms,
        path: Shape? = null,
        configuration: PathTransition.() -> Unit
    ): PathTransition = PathTransition(duration, path, node).also {
        it.configuration()
        animations += it
    }

    /**
     * Append a [RotateTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun rotate(
        duration: Duration = 400.0.ms,
        configuration: RotateTransition.() -> Unit
    ): RotateTransition = RotateTransition(duration, node).also {
        it.configuration()
        animations += it
    }

    /**
     * Append a [ScaleTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun scale(
        duration: Duration = 400.0.ms,
        configuration: ScaleTransition.() -> Unit
    ): ScaleTransition = ScaleTransition(duration, node).also {
        it.configuration()
        animations += it
    }

    /**
     * Append a [TranslateTransition].
     *
     * @param duration length of this animation.
     * @param configuration the configuration block that customizes animation.
     * @return the animation added.
     */
    fun translate(
        duration: Duration = 400.0.ms,
        configuration: TranslateTransition.() -> Unit
    ): TranslateTransition = TranslateTransition(duration, node).also {
        it.configuration()
        animations += it
    }

    /** Return array of animations based on current configuration. */
    fun build(): Array<Animation> = animations.toTypedArray()
}
