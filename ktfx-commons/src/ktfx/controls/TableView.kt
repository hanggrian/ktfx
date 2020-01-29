@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Apply [TableView.CONSTRAINED_RESIZE_POLICY] to this table. */
fun TableView<*>.constrained() {
    columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TableView.UNCONSTRAINED_RESIZE_POLICY] to this table. */
fun TableView<*>.unconstrained() {
    columnResizePolicy = TableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(configuration: TableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnsBuilder<S>(columns).configuration()
}

/** Invokes a [TableColumn] DSL builder creating multiline column. */
inline fun <S, T> TableColumn<S, T>.columns(configuration: TableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnsBuilder<S>(columns).configuration()
}

/** Interface to build [TableColumn] with Kotlin DSL. */
@TableColumnDslMarker
class TableColumnsBuilder<S> @PublishedApi internal constructor(
    private val columns: MutableCollection<TableColumn<S, *>>
) {

    fun <T> column(
        text: String? = null
    ): TableColumn<S, T> = TableColumn<S, T>(text).also { columns += it }

    inline fun <T> column(
        text: String? = null,
        init: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column(this, init)
}
