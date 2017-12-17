@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import kotfx.internal.ChildManager

class _HBox : HBox(), ChildManager, HGrowable, Marginable {
    override infix fun <N : Node> N.hGrow(value: Priority): N = apply { setHgrow(this, value) }
    override val Node.hGrow: Priority get() = getHgrow(this) ?: Priority.NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}