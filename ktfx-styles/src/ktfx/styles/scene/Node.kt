@file:Suppress("LeakingThis")

package ktfx.styles

import javafx.scene.Cursor
import javafx.scene.effect.BlendMode
import ktfx.styles.internal.NotImplemented
import ktfx.styles.internal._NodeStyleBuilder

interface NodeStyleBuilder {

    var blendMode: BlendMode

    var cursor: Cursor

    @NotImplemented
    var effect: String

    var focusTraversable: Boolean

    /**
     * Opacity can be thought of conceptually as a postprocessing operation.
     * Conceptually, after the node (including its descendants) is rendered into an RGBA offscreen image,
     * the opacity setting specifies how to blend the offscreen rendering into the current composite rendering.
     */
    var opacity: Number

    /**
     * This is the angle of the rotation in degrees.
     * Zero degrees is at 3 o'clock (directly to the right).
     * Angle values are positive clockwise. Rotation is about the center.
     */
    var rotate: Number

    /** scale about the center */
    var scaleX: Number

    /** scale about the center */
    var scaleY: Number

    /** scale about the center */
    var scaleZ: Number

    var translateX: Number

    var translateY: Number

    var translateZ: Number

    var visibility: Visibility
}

inline fun nodeStyle(
    prettyPrint: Boolean = false,
    builder: NodeStyleBuilder.() -> Unit
): String = _NodeStyleBuilder(prettyPrint).apply(builder).toString()