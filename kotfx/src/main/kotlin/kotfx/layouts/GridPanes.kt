@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
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
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import kotfx.internal.*

class _GridPane : GridPane(), Marginable, HGrowable, VGrowable {

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

    inline infix fun <T : Node> T.hAlign(pos: HPos): T = apply { setHalignment(this, pos) }
    inline val hAlign: HPos get() = getHalignment(this) ?: LEFT

    inline infix fun <T : Node> T.vAlign(pos: VPos): T = apply { setValignment(this, pos) }
    inline val vAlign: VPos get() = getValignment(this) ?: TOP

    inline fun <T : Node> T.fillWidth(): T = apply { setFillWidth(this, true) }
    inline fun <T : Node> T.unfillWidth(): T = apply { setFillWidth(this, false) }
    inline val Node.isFillWidth: Boolean get() = isFillWidth(this)

    inline fun <T : Node> T.fillHeight(): T = apply { setFillHeight(this, true) }
    inline fun <T : Node> T.unfillHeight(): T = apply { setFillHeight(this, false) }
    inline val Node.isFillHeight: Boolean get() = isFillHeight(this)

    override infix fun <T : Node> T.hgrow(priority: Priority): T = apply { setVgrow(this, priority) }
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <T : Node> T.vgrow(priority: Priority): T = apply { setVgrow(this, priority) }
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun Noded.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()