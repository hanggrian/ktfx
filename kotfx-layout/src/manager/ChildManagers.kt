package kotfx.layout

import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.HPos.LEFT
import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.geometry.VPos
import javafx.geometry.VPos.TOP
import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import javafx.scene.layout.StackPane
import javafx.scene.layout.TilePane
import javafx.scene.layout.VBox
import javafx.scene.text.TextFlow

interface ChildManager {

    fun getChildren(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getChildren().add(this) }
}

interface ConstrainedPane {
    fun <N : Node> N.reset(): N
}

interface MarginablePane : ConstrainedPane {
    infix fun <N : Node> N.margins(value: Insets?): N
    fun <N : Node> N.margins(top: Number, right: Number, bottom: Number, left: Number): N =
        margins(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

    infix fun <N : Node> N.marginTop(value: Number): N = margins(value, marginRight, marginBottom, marginLeft)
    infix fun <N : Node> N.marginRight(value: Number): N = margins(marginTop, value, marginBottom, marginLeft)
    infix fun <N : Node> N.marginBottom(value: Number): N = margins(marginTop, marginRight, value, marginLeft)
    infix fun <N : Node> N.marginLeft(value: Number): N = margins(marginTop, marginRight, marginBottom, value)

    val Node.margins: Insets
    val Node.marginTop: Double get() = margins.top
    val Node.marginRight: Double get() = margins.right
    val Node.marginBottom: Double get() = margins.bottom
    val Node.marginLeft: Double get() = margins.left
}

interface AlignablePane : ConstrainedPane {
    infix fun <N : Node> N.pos(value: Pos?): N
    infix fun <N : Node> N.hpos(value: HPos?): N = pos(posOf(vpos, value ?: hpos))
    infix fun <N : Node> N.vpos(value: VPos?): N = pos(posOf(value ?: vpos, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos
}

interface HGrowablePane : ConstrainedPane {
    infix fun <N : Node> N.hpriority(value: Priority?): N
    val Node.hpriority: Priority
}

interface VGrowablePane : ConstrainedPane {
    infix fun <N : Node> N.vpriority(value: Priority?): N
    val Node.vpriority: Priority
}

open class _AnchorPane : AnchorPane(), ChildManager, ConstrainedPane {
    infix fun <N : Node> N.anchor(value: Number?): N = apply {
        anchorTop(value)
        anchorLeft(value)
        anchorBottom(value)
        anchorRight(value)
    }

    infix fun <N : Node> N.anchorTop(value: Number?): N = apply { setTopAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorLeft(value: Number?): N = apply { setLeftAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorBottom(value: Number?): N = apply { setBottomAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorRight(value: Number?): N = apply { setRightAnchor(this, value?.toDouble()) }

    val Node.anchorTop: Double get() = getTopAnchor(this) ?: 0.0
    val Node.anchorLeft: Double get() = getLeftAnchor(this) ?: 0.0
    val Node.anchorBottom: Double get() = getBottomAnchor(this) ?: 0.0
    val Node.anchorRight: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.reset(): T = apply { clearConstraints(this) }
}

open class _BorderPane : BorderPane(), ChildManager, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _FlowPane : FlowPane(), ChildManager, MarginablePane {
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _GridPane : GridPane(), ChildManager, MarginablePane, AlignablePane, HGrowablePane, VGrowablePane {
    infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    val Node.row: Int get() = getRowIndex(this) ?: -1

    infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    val Node.col: Int get() = getColumnIndex(this) ?: -1

    infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }
    val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.pos(value: Pos?): N = apply {
        setHalignment(this, value?.hpos)
        setValignment(this, value?.vpos)
    }

    override infix fun <N : Node> N.hpos(value: HPos?): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vpos(value: VPos?): N = apply { setValignment(this, value) }

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

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _HBox : HBox(), ChildManager, HGrowablePane, MarginablePane {
    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _StackPane : StackPane(), ChildManager, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _TextFlow : TextFlow(), ChildManager

open class _TilePane : TilePane(), ChildManager, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _VBox : VBox(), ChildManager, VGrowablePane, MarginablePane {
    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let { if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it) }