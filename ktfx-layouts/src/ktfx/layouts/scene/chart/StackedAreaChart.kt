@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedAreaChart<X, Y> = stackedAreaChart(x, y, data) { }

inline fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply(init)

inline fun <X, Y> LayoutManager<Node>.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedAreaChart<X, Y> = stackedAreaChart(x, y, data) { }

inline fun <X, Y> LayoutManager<Node>.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()