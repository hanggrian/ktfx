@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.layout.Priority

interface PopupManager {

    /** Shadowed when being implemented in [javafx.scene.control.ContextMenu]. */
    fun getItems(): ObservableList<MenuItem>

    /** Convenient method to add child to this [javafx.scene.control.ContextMenu]. */
    fun <M : MenuItem> M.add(): M = apply { getItems().add(this) }
}

interface ChildManager {

    /** Shadowed when being implemented in pane. */
    fun getChildren(): ObservableList<Node>

    /** Convenient method to add child to this pane. */
    fun <N : Node> N.add(): N = apply { getChildren().add(this) }
}

internal interface Alignable : Constrained {
    infix fun <N : Node> N.pos(value: Pos): N
    infix fun <N : Node> N.hpos(value: HPos): N = pos(posOf(vpos, value))
    infix fun <N : Node> N.vpos(value: VPos): N = pos(posOf(value, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos

    fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
        if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it)
    }
}

internal interface Marginable : Constrained {
    infix fun <N : Node> N.margin(value: Insets): N
    fun <N : Node> N.margin(top: Number, right: Number, bottom: Number, left: Number): N = margin(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))
    infix fun <N : Node> N.marginTop(value: Number): N = margin(value, marginRight, marginBottom, marginLeft)
    infix fun <N : Node> N.marginRight(value: Number): N = margin(marginTop, value, marginBottom, marginLeft)
    infix fun <N : Node> N.marginBottom(value: Number): N = margin(marginTop, marginRight, value, marginLeft)
    infix fun <N : Node> N.marginLeft(value: Number): N = margin(marginTop, marginRight, marginBottom, value)

    val Node.margin2: Insets
    val Node.marginTop: Double get() = margin2.top
    val Node.marginRight: Double get() = margin2.right
    val Node.marginBottom: Double get() = margin2.bottom
    val Node.marginLeft: Double get() = margin2.left
}

internal interface HGrowable : Constrained {
    infix fun <N : Node> N.hgrow(value: Priority): N
    val Node.hgrow2: Priority
}

internal interface VGrowable : Constrained {
    infix fun <N : Node> N.vgrow(value: Priority): N
    val Node.vgrow2: Priority
}

internal interface Constrained {
    fun <N : Node> N.clearConstraints(): N
}