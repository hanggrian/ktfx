@file:Suppress("LeakingThis")

package ktfx.styles

import javafx.scene.Cursor
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Effect

enum class Visibility {
    VISIBLE, HIDDEN, COLLAPSE, INHERIT
}

open class NodeStyle : Style() {
    var blendMode: BlendMode by map
    var cursor: Cursor by map
    var effect: Effect by map
    var focusTraversable: Boolean by map
    var opacity: Number by map
    var rotate: Number by map
    var scaleX: Number by map
    var scaleY: Number by map
    var scaleZ: Number by map
    var translateX: Number by map
    var translateY: Number by map
    var translateZ: Number by map
    var visibility: Visibility by map
}

inline fun nodeStyle(vararg selectors: String, styles: NodeStyle.() -> Unit): String =
    styleOf(*selectors, styles = NodeStyle().apply(styles).toString())