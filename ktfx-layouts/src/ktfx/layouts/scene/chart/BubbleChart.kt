@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): BubbleChart<X, Y> = bubbleChart(x, y, data) { }

inline fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> = BubbleChart(x, y, data).apply(init)

inline fun <X, Y> LayoutManager<Node>.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): BubbleChart<X, Y> = bubbleChart(x, y, data) { }

inline fun <X, Y> LayoutManager<Node>.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDsl BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()