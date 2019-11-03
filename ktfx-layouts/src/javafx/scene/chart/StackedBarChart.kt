@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart.Series

/** Create a [StackedBarChart] with initialization block. */
inline fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply(init)

/** Add a [StackedBarChart] to this manager. */
fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): StackedBarChart<X, Y> = addNode(StackedBarChart(x, y, data))

/** Add a [StackedBarChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> = addNode(StackedBarChart(x, y, data), init)
