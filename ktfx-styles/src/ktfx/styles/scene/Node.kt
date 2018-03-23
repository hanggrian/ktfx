@file:Suppress("LeakingThis")

package ktfx.styles

import javafx.scene.Cursor
import javafx.scene.effect.BlendMode
import ktfx.styles.internal.StyleBuilder

open class NodeStyleBuilder(prettyPrint: Boolean) : StyleBuilder(prettyPrint) {

    var blendMode: BlendMode by map

    var cursor: Cursor by map

    @Incubating
    var effect: String by map

    var focusTraversable: Boolean by map

    /**
     * Opacity can be thought of conceptually as a postprocessing operation.
     * Conceptually, after the node (including its descendants) is rendered into an RGBA offscreen image,
     * the opacity setting specifies how to blend the offscreen rendering into the current composite rendering.
     */
    var opacity: Number by map

    /**
     * This is the angle of the rotation in degrees.
     * Zero degrees is at 3 o'clock (directly to the right).
     * Angle values are positive clockwise. Rotation is about the center.
     */
    var rotate: Number by map

    /** scale about the center */
    var scaleX: Number by map

    /** scale about the center */
    var scaleY: Number by map

    /** scale about the center */
    var scaleZ: Number by map

    var translateX: Number by map

    var translateY: Number by map

    var translateZ: Number by map

    var visibility: Visibility by map
}

enum class Visibility {
    VISIBLE, HIDDEN, COLLAPSE, INHERIT
}

inline fun nodeStyle(
    prettyPrint: Boolean = false,
    builder: NodeStyleBuilder.() -> Unit
): String = NodeStyleBuilder(prettyPrint).apply(builder).toString()