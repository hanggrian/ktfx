@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.control.TableView
import javafx.scene.control.TreeTableView

/** Apply [TableView.CONSTRAINED_RESIZE_POLICY] to this [TableView]. */
public inline fun TableView<*>.constrained() {
    columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TableView.UNCONSTRAINED_RESIZE_POLICY] to this [TableView]. */
public inline fun TableView<*>.unconstrained() {
    columnResizePolicy = TableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Apply [TreeTableView.CONSTRAINED_RESIZE_POLICY] to this [TreeTableView]. */
public inline fun TreeTableView<*>.constrained() {
    columnResizePolicy = TreeTableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TreeTableView.UNCONSTRAINED_RESIZE_POLICY] to this [TreeTableView]. */
public inline fun TreeTableView<*>.unconstrained() {
    columnResizePolicy = TreeTableView.UNCONSTRAINED_RESIZE_POLICY
}
