@file:JvmMultifileClass
@file:JvmName("ColumnsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

/** Apply [TreeTableView.CONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TreeTableView<*>.constrained() {
    columnResizePolicy = TreeTableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TreeTableView.UNCONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TreeTableView<*>.unconstrained() {
    columnResizePolicy = TreeTableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Invokes a [TreeTableColumn] DSL builder. */
fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += TreeTableColumnsBuilder<S>().apply(init).collection
}

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
class TreeTableColumnsBuilder<S> internal constructor() {
    internal val collection: MutableCollection<TreeTableColumn<S, *>> = mutableListOf()

    fun <T> column(text: String? = null): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { collection += it }

    inline fun <T> column(text: String? = null, init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T> =
        column<T>(text).apply(init)

    inline operator fun <T> String.invoke(init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T> =
        column(this, init)
}
