@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kfx.layouts

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

    fun <T : Node> T.add(): T = apply { getChildren() += this }
}

interface ConstrainedPane {

    fun Node.reset()
}

interface MarginedPane : ConstrainedPane {

    infix fun <N : Node> N.margins(value: Insets?): N
    infix fun <N : Node> N.margins(value: Int) = margins(Insets(value.toDouble()))
    fun <N : Node> N.margins(top: Int, right: Int, bottom: Int, left: Int): N =
        margins(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

    infix fun <N : Node> N.marginTop(value: Int): N = margins(value, marginRight, marginBottom, marginLeft)
    infix fun <N : Node> N.marginRight(value: Int): N = margins(marginTop, value, marginBottom, marginLeft)
    infix fun <N : Node> N.marginBottom(value: Int): N = margins(marginTop, marginRight, value, marginLeft)
    infix fun <N : Node> N.marginLeft(value: Int): N = margins(marginTop, marginRight, marginBottom, value)

    val Node.margins: Insets
    val Node.marginTop: Int get() = margins.top.toInt()
    val Node.marginRight: Int get() = margins.right.toInt()
    val Node.marginBottom: Int get() = margins.bottom.toInt()
    val Node.marginLeft: Int get() = margins.left.toInt()
}

interface AlignedPane : ConstrainedPane {

    infix fun <N : Node> N.pos(value: Pos?): N
    infix fun <N : Node> N.hpos(value: HPos?): N = pos(posOf(vpos, value ?: hpos))
    infix fun <N : Node> N.vpos(value: VPos?): N = pos(posOf(value ?: vpos, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos
}

interface HGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.hpriority(value: Priority?): N

    val Node.hpriority: Priority
}

interface VGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.vpriority(value: Priority?): N

    val Node.vpriority: Priority
}

open class _AnchorPane : AnchorPane(), ChildManager, ConstrainedPane {

    infix fun <N : Node> N.anchors(value: Int?): N = apply {
        setTopAnchor(this, value?.toDouble())
        setLeftAnchor(this, value?.toDouble())
        setBottomAnchor(this, value?.toDouble())
        setRightAnchor(this, value?.toDouble())
    }

    infix fun <N : Node> N.anchorTop(value: Int?): N = apply { setTopAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorLeft(value: Int?): N = apply { setLeftAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorBottom(value: Int?): N = apply { setBottomAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorRight(value: Int?): N = apply { setRightAnchor(this, value?.toDouble()) }

    val Node.anchorTop: Int get() = getTopAnchor(this)?.toInt() ?: 0
    val Node.anchorLeft: Int get() = getLeftAnchor(this)?.toInt() ?: 0
    val Node.anchorBottom: Int get() = getBottomAnchor(this)?.toInt() ?: 0
    val Node.anchorRight: Int get() = getRightAnchor(this)?.toInt() ?: 0

    override fun Node.reset() = clearConstraints(this)
}

inline fun anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = kfx.layouts.anchorPane(init).add()
inline fun ItemManager.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = kfx.layouts.anchorPane(init).add()
inline fun ButtonManager.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = kfx.layouts.anchorPane(init).add()

open class _BorderPane : BorderPane(), ChildManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildManager.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = kfx.layouts.borderPane(init).add()
inline fun ItemManager.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = kfx.layouts.borderPane(init).add()
inline fun ButtonManager.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = kfx.layouts.borderPane(init).add()

open class _FlowPane : FlowPane(), ChildManager, MarginedPane {

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = kfx.layouts.flowPane(init).add()
inline fun ItemManager.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = kfx.layouts.flowPane(init).add()
inline fun ButtonManager.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = kfx.layouts.flowPane(init).add()

open class _GridPane : GridPane(), ChildManager, MarginedPane, AlignedPane, HGrowedPane, VGrowedPane {

    infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }

    val Node.row: Int get() = getRowIndex(this) ?: -1
    val Node.col: Int get() = getColumnIndex(this) ?: -1
    val Node.rowSpan: Int get() = getRowSpan(this) ?: -1
    val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override infix fun <N : Node> N.hpos(value: HPos?): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vpos(value: VPos?): N = apply { setValignment(this, value) }
    override fun <N : Node> N.pos(value: Pos?): N = apply {
        setHalignment(this, value?.hpos)
        setValignment(this, value?.vpos)
    }

    override val Node.vpos: VPos get() = getValignment(this) ?: TOP
    override val Node.hpos: HPos get() = getHalignment(this) ?: LEFT
    override val Node.pos: Pos get() = posOf(vpos, hpos)

    infix fun <N : Node> N.hfill(value: Boolean): N = apply { setFillWidth(this, value) }
    infix fun <N : Node> N.vfill(value: Boolean): N = apply { setFillHeight(this, value) }
    infix fun <N : Node> N.fill(value: Boolean): N = apply {
        setFillWidth(this, value)
        setFillHeight(this, value)
    }

    val Node.hfill: Boolean get() = isFillWidth(this)
    val Node.vfill: Boolean get() = isFillHeight(this)
    val Node.fill: Boolean get() = hfill && vfill

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }

    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override fun Node.reset() = clearConstraints(this)
}

inline fun gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = kfx.layouts.gridPane(init).add()
inline fun ItemManager.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = kfx.layouts.gridPane(init).add()
inline fun ButtonManager.gridPane(init: (@LayoutDsl _GridPane).() -> Unit): GridPane = kfx.layouts.gridPane(init).add()

open class _HBox : HBox(), ChildManager, HGrowedPane, MarginedPane {

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = kfx.layouts.hbox(init).add()
inline fun ItemManager.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = kfx.layouts.hbox(init).add()
inline fun ButtonManager.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = kfx.layouts.hbox(init).add()

open class _StackPane : StackPane(), ChildManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = kfx.layouts.stackPane(init).add()
inline fun ItemManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = kfx.layouts.stackPane(init).add()
inline fun ButtonManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = kfx.layouts.stackPane(init).add()

open class _TextFlow : TextFlow(), ChildManager

inline fun textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = kfx.layouts.textFlow(init).add()
inline fun ItemManager.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = kfx.layouts.textFlow(init).add()
inline fun ButtonManager.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = kfx.layouts.textFlow(init).add()

open class _TilePane : TilePane(), ChildManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildManager.tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = kfx.layouts.tilePane(init).add()
inline fun ItemManager.tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = kfx.layouts.tilePane(init).add()
inline fun ButtonManager.tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = kfx.layouts.tilePane(init).add()

open class _VBox : VBox(), ChildManager, VGrowedPane, MarginedPane {

    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildManager.vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = kfx.layouts.vbox(init).add()
inline fun ItemManager.vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = kfx.layouts.vbox(init).add()
inline fun ButtonManager.vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = kfx.layouts.vbox(init).add()

private inline fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let { if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it) }