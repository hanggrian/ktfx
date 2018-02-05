package kotfx.scene

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
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.layout.Priority.NEVER
import javafx.scene.text.TextFlow
import kotfx.internal.posOf

//region ChildRoot
interface ChildRoot {
    /** Shadowed when being implemented in [javafx.scene.layout.Pane]. */
    fun getChildren(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.layout.Pane]. */
    fun <T : Node> T.add(): T = apply { getChildren().add(this) }
}

interface ConstrainedPane {
    fun <N : Node> N.reset(): N
}

interface MarginablePane : ConstrainedPane {
    infix fun <N : Node> N.margins(value: Insets?): N
    fun <N : Node> N.margins(top: Double, right: Double, bottom: Double, left: Double): N =
            margins(Insets(top, right, bottom, left))

    infix fun <N : Node> N.marginTop(value: Double): N = margins(value, marginRight, marginBottom, marginLeft)
    infix fun <N : Node> N.marginRight(value: Double): N = margins(marginTop, value, marginBottom, marginLeft)
    infix fun <N : Node> N.marginBottom(value: Double): N = margins(marginTop, marginRight, value, marginLeft)
    infix fun <N : Node> N.marginLeft(value: Double): N = margins(marginTop, marginRight, marginBottom, value)

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

open class _AnchorPane : AnchorPane(), ChildRoot, ConstrainedPane {
    infix fun <N : Node> N.anchor(value: Double?): N = apply {
        anchorTop(value)
        anchorLeft(value)
        anchorBottom(value)
        anchorRight(value)
    }

    infix fun <N : Node> N.anchorTop(value: Double?): N = apply { setTopAnchor(this, value) }
    infix fun <N : Node> N.anchorLeft(value: Double?): N = apply { setLeftAnchor(this, value) }
    infix fun <N : Node> N.anchorBottom(value: Double?): N = apply { setBottomAnchor(this, value) }
    infix fun <N : Node> N.anchorRight(value: Double?): N = apply { setRightAnchor(this, value) }

    val Node.anchorTop: Double get() = getTopAnchor(this) ?: 0.0
    val Node.anchorLeft: Double get() = getLeftAnchor(this) ?: 0.0
    val Node.anchorBottom: Double get() = getBottomAnchor(this) ?: 0.0
    val Node.anchorRight: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.reset(): T = apply { clearConstraints(this) }
}

open class _BorderPane : BorderPane(), ChildRoot, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _FlowPane : FlowPane(), ChildRoot, MarginablePane {
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _GridPane : GridPane(), ChildRoot, MarginablePane, AlignablePane, HGrowablePane, VGrowablePane {
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

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _HBox : HBox(), ChildRoot, HGrowablePane, MarginablePane {
    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _StackPane : StackPane(), ChildRoot, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _TextFlow : TextFlow(), ChildRoot

open class _TilePane : TilePane(), ChildRoot, AlignablePane, MarginablePane {
    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

open class _VBox : VBox(), ChildRoot, VGrowablePane, MarginablePane {
    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

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