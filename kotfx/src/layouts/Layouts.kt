package kotfx

import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.text.TextFlow

//region ChildRoot
interface ChildRoot {
    /** Shadowed when being implemented in [javafx.scene.layout.Pane]. */
    fun getChildren(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.layout.Pane]. */
    fun <T : Node> T.add(): T = apply { getChildren().add(this) }
}

internal interface ConstrainedPane {
    fun <N : Node> N.reset(): N
}

internal interface MarginablePane : ConstrainedPane {
    infix fun <N : Node> N.margins(value: Insets): N
    fun <N : Node> N.margins(top: Number, right: Number, bottom: Number, left: Number): N = margins(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))
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

internal interface AlignablePane : ConstrainedPane {
    infix fun <N : Node> N.pos(value: Pos): N
    infix fun <N : Node> N.hpos(value: HPos): N = pos(posOf(vpos, value))
    infix fun <N : Node> N.vpos(value: VPos): N = pos(posOf(value, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos

    fun posOf(v: VPos, h: HPos): Pos = "${v}_$h".let { if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it) }
}

internal interface HGrowablePane : ConstrainedPane {
    infix fun <N : Node> N.hpriority(value: Priority): N
    val Node.hpriority: Priority
}

internal interface VGrowablePane : ConstrainedPane {
    infix fun <N : Node> N.vpriority(value: Priority): N
    val Node.vpriority: Priority
}

class _AnchorPane : AnchorPane(), ChildRoot, ConstrainedPane {
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

class _BorderPane : BorderPane(), ChildRoot, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

class _FlowPane : FlowPane(), ChildRoot, MarginablePane {
    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

class _GridPane : GridPane(), ChildRoot, MarginablePane, AlignablePane, HGrowablePane, VGrowablePane {
    infix fun <N : Node> N.row(value: Int): N = apply { setRowIndex(this, value) }
    val Node.row: Int get() = getRowIndex(this) ?: -1

    infix fun <N : Node> N.col(value: Int): N = apply { setColumnIndex(this, value) }
    val Node.col: Int get() = getColumnIndex(this) ?: -1

    infix fun <N : Node> N.rowSpan(value: Int): N = apply { setRowSpan(this, value) }
    val Node.rowSpan: Int get() = getRowSpan(this) ?: -1

    infix fun <N : Node> N.colSpan(value: Int): N = apply { setColumnSpan(this, value) }
    val Node.colSpan: Int get() = getColumnSpan(this) ?: -1

    override fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.pos(value: Pos): N = apply {
        setHalignment(this, value.hpos)
        setValignment(this, value.vpos)
    }

    override infix fun <N : Node> N.hpos(value: HPos): N = apply { setHalignment(this, value) }
    override infix fun <N : Node> N.vpos(value: VPos): N = apply { setValignment(this, value) }

    override val Node.pos: Pos get() = posOf(vpos, hpos)
    override val Node.vpos: VPos get() = getValignment(this) ?: VPos.TOP
    override val Node.hpos: HPos get() = getHalignment(this) ?: HPos.LEFT

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
    override val Node.hpriority: Priority get() = getHgrow(this) ?: Priority.NEVER

    override infix fun <N : Node> N.vpriority(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: Priority.NEVER

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

class _HBox : HBox(), ChildRoot, HGrowablePane, MarginablePane {
    override infix fun <N : Node> N.hpriority(value: Priority): N = apply { setHgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: Priority.NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

class _StackPane : StackPane(), ChildRoot, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

class _TextFlow : TextFlow(), ChildRoot

class _TilePane : TilePane(), ChildRoot, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

class _VBox : VBox(), ChildRoot, VGrowablePane, MarginablePane {
    override infix fun <N : Node> N.vpriority(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: Priority.NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}
//endregion

//region ItemRoot
interface ItemRoot {
    /** Shadowed when being implemented in [javafx.scene.control.ToolBar]. */
    fun getItems(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.control.ToolBar]. */
    fun <T : Node> T.add(): T = apply { getItems().add(this) }
}

class _ToolBar(vararg items: Node) : ToolBar(*items), ItemRoot
//endregion

//region MenuRoot
interface MenuRoot {
    /** Shadowed when being implemented in [javafx.scene.control.MenuBar]. */
    fun getMenus(): ObservableList<Menu>

    /** Convenient method to add child to this [javafx.scene.control.MenuBar]. */
    fun <T : Menu> T.add(): T = apply { getMenus().add(this) }
}

class _MenuBar(vararg menus: Menu) : MenuBar(*menus), MenuRoot
//endregion

//region PopupRoot
interface PopupRoot {
    /** Shadowed when being implemented in [javafx.scene.control.ContextMenu]. */
    fun getItems(): ObservableList<MenuItem>

    /** Convenient method to add child to this [javafx.scene.control.ContextMenu]. */
    fun <T : MenuItem> T.add(): T = apply { getItems().add(this) }
}

class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupRoot
//endregion