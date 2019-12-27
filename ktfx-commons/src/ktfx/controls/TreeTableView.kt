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
fun <S> TreeTableView<S>.columns(configuration: TreeTableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnsBuilder<S>(columns).configuration()
}

/** Invokes a [TreeTableColumn] DSL builder creating multiline column. */
fun <S, T> TreeTableColumn<S, T>.columns(configuration: TreeTableColumnsBuilder<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnsBuilder<S>(columns).configuration()
}

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
@TableColumnDslMarker
class TreeTableColumnsBuilder<S> internal constructor(private val columns: MutableCollection<TreeTableColumn<S, *>>) {

    fun <T> column(
        text: String? = null
    ): TreeTableColumn<S, T> = TreeTableColumn<S, T>(text).also { columns += it }

    inline fun <T> column(
        text: String? = null,
        init: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column(this, init)
}
