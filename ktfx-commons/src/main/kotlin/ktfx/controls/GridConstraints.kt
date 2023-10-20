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
fun GridPane.rowConstraints(configuration: RowConstraintsScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    object : RowConstraintsScope {
        override val constraints: ObservableList<RowConstraints> get() = rowConstraints
    }.configuration()
}

/**
 * Configure [GridPane] column constraints.
 *
 * @param configuration the configuration block.
 */
fun GridPane.columnConstraints(configuration: ColumnConstraintsScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    object : ColumnConstraintsScope {
        override val constraints: ObservableList<ColumnConstraints> get() = columnConstraints
    }.configuration()
}

/** [RowConstraints] configurator interface. */
interface RowConstraintsScope {
    /** Constraints of this scope. */
    val constraints: ObservableList<RowConstraints>

    /** Add a default [RowConstraints], returning the constraints added. */
    fun append(): RowConstraints = RowConstraints().also { constraints += it }

    /** Add a [RowConstraints] using [configuration] block, returning the constraints added. */
    fun append(configuration: RowConstraints.() -> Unit): RowConstraints =
        RowConstraints().also {
            it.configuration()
            constraints += it
        }
}

/** [ColumnConstraints] configurator interface. */
interface ColumnConstraintsScope {
    /** Constraints of this scope. */
    val constraints: ObservableList<ColumnConstraints>

    /** Add a default [ColumnConstraints], returning the constraints added. */
    fun append(): ColumnConstraints = ColumnConstraints().also { constraints += it }

    /** Add a [ColumnConstraints] using [configuration] block, returning the constraints added. */
    fun append(configuration: ColumnConstraints.() -> Unit): ColumnConstraints =
        ColumnConstraints().also {
            it.configuration()
            constraints += it
        }
}
