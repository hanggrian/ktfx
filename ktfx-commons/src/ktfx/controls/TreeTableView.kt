@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Apply [TreeTableView.CONSTRAINED_RESIZE_POLICY] to this [TreeTableView]. */
@Suppress("NOTHING_TO_INLINE")
inline fun TreeTableView<*>.constrained() {
    columnResizePolicy = TreeTableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TreeTableView.UNCONSTRAINED_RESIZE_POLICY] to this [TreeTableView]. */
@Suppress("NOTHING_TO_INLINE")
inline fun TreeTableView<*>.unconstrained() {
    columnResizePolicy = TreeTableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Return columns configurator of this [TreeTableView]. */
inline val <S> TreeTableView<S>.tableColumns: TreeTableColumnContainer<S> get() = TreeTableColumnContainer(columns)

/** Configure columns of this [TreeTableView] using [configuration] block. */
inline fun <S> TreeTableView<S>.tableColumns(configuration: TreeTableColumnContainerScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnContainerScope<S>(columns).configuration()
}

/** Return columns configurator of this [TreeTableColumn]. */
inline val <S> TreeTableColumn<S, *>.tableColumns: TreeTableColumnContainer<S> get() = TreeTableColumnContainer(columns)

/** Configure columns of this [TreeTableColumn] using [configuration] block. */
inline fun <S> TreeTableColumn<S, *>.tableColumns(configuration: TreeTableColumnContainerScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnContainerScope<S>(columns).configuration()
}

/** Container of [TreeTableColumn], providing sets of useful operation. */
open class TreeTableColumnContainer<S> @PublishedApi internal constructor(
    @PublishedApi internal val columns: MutableCollection<TreeTableColumn<S, *>>
) {

    /** Add a default column using [text], returning the column added. */
    fun <T> column(text: String? = null): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> column(
        text: String? = null,
        configuration: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> {
        val column = TreeTableColumn<S, T>(text)
        column.configuration()
        columns += column
        return column
    }
}

/** Receiver for `tableColumns` block. */
@TableColumnDslMarker
class TreeTableColumnContainerScope<S> @PublishedApi internal constructor(
    columns: MutableCollection<TreeTableColumn<S, *>>
) : TreeTableColumnContainer<S>(columns) {

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = column(this, configuration)
}
