@file:Suppress("PackageDirectoryMismatch", "LeakingThis", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.scene.Cursor
import javafx.scene.effect.BlendMode

open class _NodeStyleBuilder(
    prettyPrint: Boolean
) : StyleBuilder(prettyPrint), NodeStyleBuilder {
    override var blendMode: BlendMode by map
    override var cursor: Cursor by map
    override var effect: String by map
    override var focusTraversable: Boolean by map
    override var opacity: Number by map
    override var rotate: Number by map
    override var scaleX: Number by map
    override var scaleY: Number by map
    override var scaleZ: Number by map
    override var translateX: Number by map
    override var translateY: Number by map
    override var translateZ: Number by map
    override var visibility: Visibility by map
}

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