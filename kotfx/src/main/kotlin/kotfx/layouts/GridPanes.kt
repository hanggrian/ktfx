@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.HPos
import javafx.geometry.HPos.LEFT
import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.VPos
import javafx.geometry.VPos.TOP
import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER

class _GridPane : GridPane(), Marginable, HGrowable, VGrowable {

    inline infix fun Node.rowIndex(index: Int) = setRowIndex(this, index)
    inline val Node.rowIndex: Int get() = getRowIndex(this) ?: -1

    inline infix fun Node.columnIndex(index: Int) = setColumnIndex(this, index)
    inline val Node.columnIndex: Int get() = getColumnIndex(this) ?: -1

    inline infix fun Node.rowSpan(index: Int) = setRowSpan(this, index)
    inline val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    inline infix fun Node.columnSpan(index: Int) = setColumnSpan(this, index)
    inline val Node.columnSpan: Int get() = getColumnSpan(this) ?: -1

    override fun Node.margin(insets: Insets) = setMargin(this, insets)
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    inline infix fun hAlign(pos: HPos) = setHalignment(this, pos)
    inline val hAlign: HPos get() = getHalignment(this) ?: LEFT

    inline infix fun vAlign(pos: VPos) = setValignment(this, pos)
    inline val vAlign: VPos get() = getValignment(this) ?: TOP

    inline fun Node.fillWidth() = setFillWidth(this, true)
    inline fun Node.unfillWidth() = setFillWidth(this, false)
    inline val Node.isFillWidth: Boolean get() = isFillWidth(this)

    inline fun Node.fillHeight() = setFillHeight(this, true)
    inline fun Node.unfillHeight() = setFillHeight(this, false)
    inline val Node.isFillHeight: Boolean get() = isFillHeight(this)

    override infix fun Node.hgrow(priority: Priority) = setVgrow(this, priority)
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun Node.vgrow(priority: Priority) = setVgrow(this, priority)
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override fun Node.removeConstraints() = clearConstraints(this)
}