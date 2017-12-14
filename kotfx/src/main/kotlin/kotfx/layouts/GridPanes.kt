@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.HPos
import javafx.geometry.HPos.LEFT
import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.geometry.VPos.TOP
import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import kotfx._Pane
import kotfx.internal.LayoutDsl

class _GridPane : GridPane(), _MarginablePane, _AlignablePane, _HGrowablePane, _VGrowablePane {
    override val node: Pane get() = this

    inline infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    inline val Node.row: Int get() = getRowIndex(this) ?: -1

    inline infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    inline val Node.col: Int get() = getColumnIndex(this) ?: -1

    inline infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    inline val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    inline infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }
    inline val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margin(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.pos(value: Pos): N = apply {
        setHalignment(this, value.hpos)
        setValignment(this, value.vpos)
    }

    override infix fun <N : Node> N.hpos(value: HPos): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vpos(value: VPos): N = apply { setValignment(this, value) }

    override val Node.pos: Pos get() = posOf(vpos, hpos)
    override val Node.vpos: VPos get() = getValignment(this) ?: TOP
    override val Node.hpos: HPos get() = getHalignment(this) ?: LEFT

    inline infix fun <N : Node> N.fillWidth(value: Boolean): N = apply { setFillWidth(this, value) }
    inline val Node.isFillWidth: Boolean get() = isFillWidth(this)

    inline infix fun <N : Node> N.fillHeight(value: Boolean): N = apply { setFillHeight(this, value) }
    inline val Node.isFillHeight: Boolean get() = isFillHeight(this)

    inline infix fun <N : Node> N.fillSize(value: Boolean): N = apply {
        setFillWidth(this, value)
        setFillHeight(this, value)
    }

    inline val Node.isFillSize: Boolean get() = isFillWidth && isFillHeight

    override infix fun <N : Node> N.hgrow(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.vgrow(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override fun <N : Node> N.clearConstraints(): N = apply { clearConstraints(this) }
}

inline fun gridPaneOf(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun _Pane.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = gridPaneOf(init).add()