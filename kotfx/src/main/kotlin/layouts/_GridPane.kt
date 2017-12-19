package kotfx

import javafx.geometry.HPos
import javafx.geometry.HPos.LEFT
import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.geometry.VPos.TOP
import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER

class _GridPane : GridPane(), ChildManager, MarginablePane, AlignablePane, HGrowablePane, VGrowablePane {
    infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    val Node.row: Int get() = getRowIndex(this) ?: -1

    infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    val Node.col: Int get() = getColumnIndex(this) ?: -1

    infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }
    val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.pos(value: Pos): N = apply {
        setHalignment(this, value.hpos)
        setValignment(this, value.vpos)
    }

    override infix fun <N : Node> N.hpos(value: HPos): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vpos(value: VPos): N = apply { setValignment(this, value) }

    override val Node.pos: Pos get() = posOf(vpos, hpos)
    override val Node.vpos: VPos get() = getValignment(this) ?: TOP
    override val Node.hpos: HPos get() = getHalignment(this) ?: LEFT

    infix fun <N : Node> N.hfill(value: Boolean): N = apply { setFillWidth(this, value) }
    val Node.hfill: Boolean get() = isFillWidth(this)

    infix fun <N : Node> N.vfill(value: Boolean): N = apply { setFillHeight(this, value) }
    val Node.vfill: Boolean get() = isFillHeight(this)

    infix fun <N : Node> N.fill(value: Boolean): N = apply {
        setFillWidth(this, value)
        setFillHeight(this, value)
    }

    val Node.fill: Boolean get() = hfill && vfill

    override infix fun <N : Node> N.hpriority(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.vpriority(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}