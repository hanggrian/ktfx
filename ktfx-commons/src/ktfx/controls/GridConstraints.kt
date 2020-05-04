@file:OptIn(ExperimentalContracts::class)

package ktfx.controls

import javafx.collections.ObservableList
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Return row constraints configurator of this [GridPane]. */
val GridPane.rowConstraints2: RowConstraintsContainer get() = RowConstraintsContainer(rowConstraints)

/** Configure row constraints of this [GridPane] using [configuration] block. */
fun GridPane.rowConstraints(configuration: RowConstraintsContainer.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    RowConstraintsContainer(rowConstraints).apply(configuration)
}

/** Return column constraints configurator of this [GridPane]. */
val GridPane.columnConstraints2: ColumnConstraintsContainer get() = ColumnConstraintsContainer(columnConstraints)

/** Configure column constraints of this [GridPane] using [configuration] block. */
fun GridPane.columnConstraints(configuration: ColumnConstraintsContainer.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    ColumnConstraintsContainer(columnConstraints).apply(configuration)
}

/** Container of [RowConstraints], providing sets of useful operation. */
class RowConstraintsContainer internal constructor(val constraints: ObservableList<RowConstraints>) {

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
class ColumnConstraintsContainer internal constructor(val constraints: ObservableList<ColumnConstraints>) {

    /** Add a default [ColumnConstraints], returning the constraints added. */
    fun append(): ColumnConstraints = ColumnConstraints().also { constraints += it }

    /** Add a [ColumnConstraints] using [configuration] block, returning the constraints added. */
    inline fun append(configuration: ColumnConstraints.() -> Unit): ColumnConstraints {
        val constraints = ColumnConstraints().apply(configuration)
        this.constraints += constraints
        return constraints
    }
}
