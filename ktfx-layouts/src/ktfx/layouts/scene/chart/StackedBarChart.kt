@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedBarChart<X, Y> = stackedBarChart(x, y, data) { }

inline fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply(init)

inline fun <X, Y> LayoutManager<Node>.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedBarChart<X, Y> = stackedBarChart(x, y, data) { }

inline fun <X, Y> LayoutManager<Node>.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()