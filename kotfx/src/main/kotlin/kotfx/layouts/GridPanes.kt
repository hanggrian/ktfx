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
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.LayoutDsl

class _GridPane : GridPane(), ChildManager, Marginable, Alignable, HGrowable, VGrowable {
    inline infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    inline val Node.row: Int get() = getRowIndex(this) ?: -1

    inline infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    inline val Node.col: Int get() = getColumnIndex(this) ?: -1

    inline infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    inline val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    inline infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }
    inline val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.pos(value: Pos): N = apply {
        setHalignment(this, value.hpos)
        setValignment(this, value.vpos)
    }

    override infix fun <N : Node> N.hPos(value: HPos): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vPos(value: VPos): N = apply { setValignment(this, value) }

    override val Node.pos: Pos get() = posOf(vPos, hPos)
    override val Node.vPos: VPos get() = getValignment(this) ?: TOP
    override val Node.hPos: HPos get() = getHalignment(this) ?: LEFT

    inline infix fun <N : Node> N.fillWidth(value: Boolean): N = apply { setFillWidth(this, value) }
    inline val Node.isFillWidth: Boolean get() = isFillWidth(this)

    inline infix fun <N : Node> N.fillHeight(value: Boolean): N = apply { setFillHeight(this, value) }
    inline val Node.isFillHeight: Boolean get() = isFillHeight(this)

    inline infix fun <N : Node> N.fillSize(value: Boolean): N = apply {
        setFillWidth(this, value)
        setFillHeight(this, value)
    }

    inline val Node.isFillSize: Boolean get() = isFillWidth && isFillHeight

    override infix fun <N : Node> N.hGrow(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.hGrow: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.vGrow(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vGrow: Priority get() = getVgrow(this) ?: NEVER

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

inline fun gridPaneOf(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ItemManager.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()