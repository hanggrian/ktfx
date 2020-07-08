@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.controls

import com.jfoenix.controls.JFXTreeTableColumn
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeTableColumn
import ktfx.controls.TableColumnDslMarker
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Configure [JFXTreeTableView] columns.
 * @param configuration the configuration block.
 */
fun <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.columns(
    configuration: JFXTreeTableColumnScope<S>.() -> Unit
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JFXTreeTableColumnScope(columns).configuration()
}

/**
 * Configure [JFXTreeTableColumn] columns, essentially enabling multi-line column.
 * @param configuration the configuration block.
 */
fun <S : RecursiveTreeObject<S>> JFXTreeTableColumn<S, *>.columns(
    configuration: JFXTreeTableColumnScope<S>.() -> Unit
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JFXTreeTableColumnScope(columns).configuration()
}

/** Container of [JFXTreeTableColumn], providing sets of useful operation. */
@TableColumnDslMarker
class JFXTreeTableColumnScope<S : RecursiveTreeObject<S>> internal constructor(
    val columns: MutableCollection<TreeTableColumn<S, *>>
) {

    /** Add a default column using [text], returning the column added. */
    fun <T> column(text: String? = null): JFXTreeTableColumn<S, T> =
        JFXTreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> column(
        text: String? = null,
        configuration: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> {
        val column = JFXTreeTableColumn<S, T>(text).apply(configuration)
        columns += column
        return column
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: JFXTreeTableColumn<S, T>.() -> Unit
    ): JFXTreeTableColumn<S, T> = column(this, configuration)
}
