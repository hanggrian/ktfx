@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.FlowPane

class _FlowPane : FlowPane(), Marginable {

    override infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.removeConstraints() = clearConstraints(this)
}