@file:JvmMultifileClass
@file:JvmName("ColumnKt")
@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Apply [TreeTableView.CONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TreeTableView<*>.constrained() {
    columnResizePolicy = TreeTableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TreeTableView.UNCONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TreeTableView<*>.unconstrained() {
    columnResizePolicy = TreeTableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Invokes a [TreeTableColumn] DSL builder. */
fun <S> TreeTableView<S>.columns(builder: TreeTableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(builder, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnsBuilder<S>(columns).builder()
}

/** Invokes a [TreeTableColumn] DSL builder creating multiline column. */
fun <S, T> TreeTableColumn<S, T>.columns(builder: TreeTableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(builder, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnsBuilder<S>(columns).builder()
}
