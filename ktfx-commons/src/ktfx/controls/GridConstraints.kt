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
 * @param configuration the configuration block.
 */
fun GridPane.rowConstraints(configuration: RowConstraintsScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    RowConstraintsScope(rowConstraints).apply(configuration)
}

/**
 * Configure [GridPane] column constraints.
 * @param configuration the configuration block.
 */
fun GridPane.columnConstraints(configuration: ColumnConstraintsScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    ColumnConstraintsScope(columnConstraints).apply(configuration)
}

/** Container of [RowConstraints], providing sets of useful operation. */
class RowConstraintsScope internal constructor(val constraints: ObservableList<RowConstraints>) {

    /** Add a default [RowConstraints], returning the constraints added. */
    fun append(): RowConstraints = RowConstraints().also { constraints += it }

    /** Add a [RowConstraints] using [configuration] block, returning the constraints added. */
    inline fun append(configuration: RowConstraints.() -> Unit): RowConstraints {
        val constraints = RowConstraints().apply(configuration)
        this.constraints += constraints
        return constraints
    }
}

/** Container of [ColumnConstraints], providing sets of useful operation. */
class ColumnConstraintsScope internal constructor(val constraints: ObservableList<ColumnConstraints>) {

    /** Add a default [ColumnConstraints], returning the constraints added. */
    fun append(): ColumnConstraints = ColumnConstraints().also { constraints += it }

    /** Add a [ColumnConstraints] using [configuration] block, returning the constraints added. */
    inline fun append(configuration: ColumnConstraints.() -> Unit): ColumnConstraints {
        val constraints = ColumnConstraints().apply(configuration)
        this.constraints += constraints
        return constraints
    }
}
