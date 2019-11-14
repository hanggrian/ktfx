@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart.Series
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [BarChart] with initialization block. */
inline fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0,
    init: BarChart<X, Y>.() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return BarChart(x, y, data, gap).apply(init)
}

/** Add a [BarChart] to this manager. */
fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0
): BarChart<X, Y> = addNode(BarChart(x, y, data, gap))

/** Add a [BarChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0,
    init: BarChart<X, Y>.() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(BarChart(x, y, data, gap), init)
}
