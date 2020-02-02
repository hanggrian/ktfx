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
    categoryGap: Double = 10.0,
    init: (@LayoutsDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return BarChart(x, y, data, categoryGap).apply(init)
}

/** Add a [BarChart] to this manager. */
fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    categoryGap: Double = 10.0
): BarChart<X, Y> = addChild(BarChart(x, y, data, categoryGap))

/** Add a [BarChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    categoryGap: Double = 10.0,
    init: (@LayoutsDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(BarChart(x, y, data, categoryGap), init)
}
