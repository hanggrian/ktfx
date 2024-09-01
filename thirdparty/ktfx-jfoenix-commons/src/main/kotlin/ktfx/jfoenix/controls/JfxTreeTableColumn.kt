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
public inline fun <S : RecursiveTreeObject<S>> JFXTreeTableView<S>.columns(
    configuration: JfxTreeTableColumnScope<S>.() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JfxTreeTableColumnScope<S>(columns).configuration()
}

/**
 * Configure [JFXTreeTableColumn] columns, essentially enabling multi-line column.
 *
 * @param configuration the configuration block.
 */
public inline fun <S : RecursiveTreeObject<S>> JFXTreeTableColumn<S, *>.columns(
    configuration: JfxTreeTableColumnScope<S>.() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    JfxTreeTableColumnScope<S>(columns).configuration()
}

/**
 * Container of [JFXTreeTableColumn], providing sets of useful operation.
 *
 * @property columns collection of columns within this scope.
 */
@TableColumnDslMarker
public class JfxTreeTableColumnScope<S : RecursiveTreeObject<S>>(
    public val columns: MutableCollection<TreeTableColumn<S, *>>,
) {
    /** Add a default column using [text], returning the column added. */
    public fun <T> append(text: String? = null): JFXTreeTableColumn<S, T> =
        JFXTreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    public inline fun <T> append(
        text: String? = null,
        configuration: JFXTreeTableColumn<S, T>.() -> Unit,
    ): JFXTreeTableColumn<S, T> {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return JFXTreeTableColumn<S, T>(text)
            .also {
                it.configuration()
                columns += it
            }
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    public inline operator fun <T> String.invoke(
        configuration: JFXTreeTableColumn<S, T>.() -> Unit,
    ): JFXTreeTableColumn<S, T> = append(this, configuration)
}
