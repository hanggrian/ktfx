@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER

class _HBox : HBox(), HGrowable, Marginable {

    override infix fun Node.hgrow(priority: Priority) = setHgrow(this, priority)
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.removeConstraints() = clearConstraints(this)
}