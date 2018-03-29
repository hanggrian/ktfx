@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10
): BarChart<X, Y> = barChart(x, y, data, gap) { }

fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10,
    init: (@LayoutDsl BarChart<X, Y>).() -> Unit
): BarChart<X, Y> = BarChart(x, y, data, gap.toDouble()).apply(init)

inline fun <X, Y> LayoutManager<Node>.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10
): BarChart<X, Y> = barChart(x, y, data, gap) { }

inline fun <X, Y> LayoutManager<Node>.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10,
    noinline init: (@LayoutDsl BarChart<X, Y>).() -> Unit
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()