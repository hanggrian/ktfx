@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.controls

import com.jfoenix.controls.JFXTreeTableColumn
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeTableColumn
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.controls.TableColumnDslMarker

/** Return columns configurator of this [JFXTreeTableView]. */
inline val <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.tableColumns: JFXTreeTableColumnContainer<S>
    get() = JFXTreeTableColumnContainer(columns)

/** Configure columns of this [JFXTreeTableView] using [configuration] block. */
inline fun <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.tableColumns(
    configuration: JFXTreeTableColumnContainerScope<S>.() -> Unit
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JFXTreeTableColumnContainerScope<S>(columns).configuration()
}

/** Return columns configurator of this [JFXTreeTableColumn]. */
inline val <S : RecursiveTreeObject<S>> JFXTreeTableColumn<S, *>.tableColumns: JFXTreeTableColumnContainer<S>
    get() = JFXTreeTableColumnContainer(columns)

/** Configure columns of this [JFXTreeTableColumn] using [configuration] block. */
inline fun <S : RecursiveTreeObject<S>> JFXTreeTableColumn<S, *>.tableColumns(
    configuration: JFXTreeTableColumnContainerScope<S>.() -> Unit
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JFXTreeTableColumnContainerScope<S>(columns).configuration()
}

/** Container of [JFXTreeTableColumn], providing sets of useful operation. */
open class JFXTreeTableColumnContainer<S : RecursiveTreeObject<S>> @PublishedApi internal constructor(
    @PublishedApi internal val columns: MutableCollection<TreeTableColumn<S, *>>
) {

    /** Add a default column using [text], returning the column added. */
    fun <T> column(text: String? = null): JFXTreeTableColumn<S, T> =
        JFXTreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> column(
        text: String? = null,
        configuration: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> {
        val column = JFXTreeTableColumn<S, T>(text)
        column.configuration()
        columns += column
        return column
    }
}

/** Receiver for `tableColumns` block. */
@TableColumnDslMarker
class JFXTreeTableColumnContainerScope<S : RecursiveTreeObject<S>> @PublishedApi internal constructor(
    columns: MutableCollection<TreeTableColumn<S, *>>
) : JFXTreeTableColumnContainer<S>(columns) {

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> = column(this, configuration)
}
