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
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _GridPane : GridPane(), _Marginable, _Alignable, _HGrowable, _VGrowable {

    override val instance: Pane get() = this

    inline infix fun <T : Node> T.row(index: Int): T = apply { setRowIndex(this, index) }
    inline val Node.row: Int get() = getRowIndex(this) ?: -1

    inline infix fun <T : Node> T.col(index: Int): T = apply { setColumnIndex(this, index) }
    inline val Node.col: Int get() = getColumnIndex(this) ?: -1

    inline infix fun <T : Node> T.rowSpan(index: Int): T = apply { setRowSpan(this, index) }
    inline val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    inline infix fun <T : Node> T.colSpan(index: Int): T = apply { setColumnSpan(this, index) }
    inline val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <T : Node> T.margin(insets: Insets): T = apply { setMargin(this, insets) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <T : Node> T.pos(pos: Pos): T = apply {
        setHalignment(this, pos.hpos)
        setValignment(this, pos.vpos)
    }

    override infix fun <T : Node> T.hpos(hpos: HPos): T = apply { setHalignment(this, hpos) }
    override infix fun <T : Node> T.vpos(vpos: VPos): T = apply { setValignment(this, vpos) }

    override val Node.pos: Pos get() = posOf(vpos, hpos)
    override val Node.vpos: VPos get() = getValignment(this) ?: TOP
    override val Node.hpos: HPos get() = getHalignment(this) ?: LEFT

    inline infix fun <T : Node> T.fillWidth(value: Boolean): T = apply { setFillWidth(this, value) }
    inline val Node.isFillWidth: Boolean get() = isFillWidth(this)

    inline infix fun <T : Node> T.fillHeight(value: Boolean): T = apply { setFillHeight(this, value) }
    inline val Node.isFillHeight: Boolean get() = isFillHeight(this)

    inline infix fun <T : Node> T.fillSize(value: Boolean): T = apply {
        setFillWidth(this, value)
        setFillHeight(this, value)
    }

    inline val Node.isFillSize: Boolean get() = isFillWidth && isFillHeight

    override infix fun <T : Node> T.hgrow(priority: Priority): T = apply { setVgrow(this, priority) }
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <T : Node> T.vgrow(priority: Priority): T = apply { setVgrow(this, priority) }
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()