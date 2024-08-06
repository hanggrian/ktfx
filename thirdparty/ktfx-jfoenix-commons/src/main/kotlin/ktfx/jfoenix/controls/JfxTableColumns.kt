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
 *
 * @param configuration the configuration block.
 */
fun <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.columns(
    configuration: JfxTreeTableColumnScope<S>.() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    val columns2 = columns // explicit ref to avoid ambiguous label
    object : JfxTreeTableColumnScope<S> {
        override val columns: MutableCollection<TreeTableColumn<S, *>> get() = columns2
    }.configuration()
}

/**
 * Configure [JFXTreeTableColumn] columns, essentially enabling multi-line column.
 *
 * @param configuration the configuration block.
 */
fun <S : RecursiveTreeObject<S>> JFXTreeTableColumn<S, *>.columns(
    configuration: JfxTreeTableColumnScope<S>.() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    val columns2 = columns // explicit ref to avoid ambiguous label
    object : JfxTreeTableColumnScope<S> {
        override val columns: MutableCollection<TreeTableColumn<S, *>> get() = columns2
    }.configuration()
}

/** Container of [JFXTreeTableColumn], providing sets of useful operation. */
@TableColumnDslMarker
interface JfxTreeTableColumnScope<S : RecursiveTreeObject<S>> {
    /** Collection of columns within this scope. */
    val columns: MutableCollection<TreeTableColumn<S, *>>

    /** Add a default column using [text], returning the column added. */
    fun <T> column(text: String? = null): JFXTreeTableColumn<S, T> =
        JFXTreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    fun <T> column(
        text: String? = null,
        configuration: JFXTreeTableColumn<S, T>.() -> Unit,
    ): JFXTreeTableColumn<S, T> {
        val column = JFXTreeTableColumn<S, T>(text).apply(configuration)
        columns += column
        return column
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    operator fun <T> String.invoke(
        configuration: JFXTreeTableColumn<S, T>.() -> Unit,
    ): JFXTreeTableColumn<S, T> = column(this, configuration)
}
