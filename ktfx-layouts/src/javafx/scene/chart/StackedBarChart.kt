@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart.Series
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [StackedBarChart] with configurationialization block. */
inline fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return StackedBarChart(x, y, data).apply(configuration)
}

/** Add a [StackedBarChart] to this manager. */
fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): StackedBarChart<X, Y> = addChild(StackedBarChart(x, y, data))

/** Add a [StackedBarChart] with configurationialization block to this manager. */
inline fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(StackedBarChart(x, y, data), configuration)
}
