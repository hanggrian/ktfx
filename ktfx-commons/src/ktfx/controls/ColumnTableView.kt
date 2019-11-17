@file:JvmMultifileClass
@file:JvmName("ColumnKt")
@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Apply [TableView.CONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TableView<*>.constrained() {
    columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TableView.UNCONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TableView<*>.unconstrained() {
    columnResizePolicy = TableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Invokes a [TableColumn] DSL builder. */
fun <S> TableView<S>.columns(builder: TableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(builder, InvocationKind.EXACTLY_ONCE) }
    TableColumnsBuilder<S>(columns).builder()
}

/** Invokes a [TableColumn] DSL builder creating multiline column. */
fun <S, T> TableColumn<S, T>.columns(builder: TableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(builder, InvocationKind.EXACTLY_ONCE) }
    TableColumnsBuilder<S>(columns).builder()
}
