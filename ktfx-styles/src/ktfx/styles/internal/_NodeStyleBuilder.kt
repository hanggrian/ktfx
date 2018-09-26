@file:Suppress("ClassName")

package ktfx.styles.internal

import javafx.scene.Cursor
import javafx.scene.effect.BlendMode
import ktfx.styles.NodeStyleBuilder
import ktfx.styles.Visibility

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