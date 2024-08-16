@file:OptIn(ExperimentalContracts::class)

package ktfx.controls

import javafx.collections.ObservableList
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Configure [GridPane] row constraints.
 *
 * @param configuration the configuration block.
 */
public inline fun GridPane.rowConstraints(configuration: RowConstraintsScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    RowConstraintsScope(rowConstraints).configuration()
}

/**
 * Configure [GridPane] column constraints.
 *
 * @param configuration the configuration block.
 */
public inline fun GridPane.columnConstraints(configuration: ColumnConstraintsScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    ColumnConstraintsScope(columnConstraints).configuration()
}

/**
 * [RowConstraints] configurator interface.
 *
 * @param constraints constraints of this scope.
 */
public class RowConstraintsScope(public val constraints: ObservableList<RowConstraints>) {
    /** Add a default [RowConstraints], returning the constraints added. */
    public fun append(): RowConstraints = RowConstraints().also { constraints += it }

    /** Add a [RowConstraints] using [configuration] block, returning the constraints added. */
    public inline fun append(configuration: RowConstraints.() -> Unit): RowConstraints {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return RowConstraints().also {
            it.configuration()
            constraints += it
        }
    }
}

/**
 * [ColumnConstraints] configurator interface.
 *
 * @property constraints constraints of this scope.
 */
public class ColumnConstraintsScope(public val constraints: ObservableList<ColumnConstraints>) {
    /** Add a default [ColumnConstraints], returning the constraints added. */
    public fun append(): ColumnConstraints = ColumnConstraints().also { constraints += it }

    /** Add a [ColumnConstraints] using [configuration] block, returning the constraints added. */
    public inline fun append(configuration: ColumnConstraints.() -> Unit): ColumnConstraints {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return ColumnConstraints().also {
            it.configuration()
            constraints += it
        }
    }
}
