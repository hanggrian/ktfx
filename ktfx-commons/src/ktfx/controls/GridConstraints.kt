@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controls

import javafx.collections.ObservableList
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Return row constraints configurator of this [GridPane]. */
inline val GridPane.rowConstraints2: RowConstraintsContainer get() = RowConstraintsContainer(rowConstraints)

/** Configure row constraints of this [GridPane] using [configuration] block. */
inline fun GridPane.rowConstraints(configuration: RowConstraintsContainer.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    RowConstraintsContainer(rowConstraints).apply(configuration)
}

/** Return column constraints configurator of this [GridPane]. */
inline val GridPane.columnConstraints2: ColumnConstraintsContainer get() = ColumnConstraintsContainer(columnConstraints)

/** Configure column constraints of this [GridPane] using [configuration] block. */
inline fun GridPane.columnConstraints(configuration: ColumnConstraintsContainer.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    ColumnConstraintsContainer(columnConstraints).apply(configuration)
}

/** Container of [RowConstraints], providing sets of useful operation. */
class RowConstraintsContainer @PublishedApi internal constructor(
    @PublishedApi internal val constraints: ObservableList<RowConstraints>
) {

    /** Add a default [RowConstraints], returning the constraints added. */
    fun constraints(): RowConstraints = RowConstraints().also { constraints += it }

    /** Add a [RowConstraints] using [configuration] block, returning the constraints added. */
    inline fun constraints(configuration: RowConstraints.() -> Unit): RowConstraints {
        val constraints = RowConstraints()
        constraints.configuration()
        this.constraints += constraints
        return constraints
    }
}

/** Container of [ColumnConstraints], providing sets of useful operation. */
class ColumnConstraintsContainer @PublishedApi internal constructor(
    @PublishedApi internal val constraints: ObservableList<ColumnConstraints>
) {

    /** Add a default [ColumnConstraints], returning the constraints added. */
    fun constraints(): ColumnConstraints = ColumnConstraints().also { constraints += it }

    /** Add a [ColumnConstraints] using [configuration] block, returning the constraints added. */
    inline fun constraints(configuration: ColumnConstraints.() -> Unit): ColumnConstraints {
        val constraints = ColumnConstraints()
        constraints.configuration()
        this.constraints += constraints
        return constraints
    }
}
