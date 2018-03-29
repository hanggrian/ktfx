@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): AreaChart<X, Y> = areaChart(x, y, data) { }

inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> = AreaChart(x, y, data).apply(init)

inline fun <X, Y> LayoutManager<Node>.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): AreaChart<X, Y> = areaChart(x, y, data) { }

inline fun <X, Y> LayoutManager<Node>.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()