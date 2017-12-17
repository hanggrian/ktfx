@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import kotfx.internal.ChildManager

class _VBox : VBox(), ChildManager, VGrowable, Marginable {
    override infix fun <N : Node> N.vGrow(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vGrow: Priority get() = getVgrow(this) ?: Priority.NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}