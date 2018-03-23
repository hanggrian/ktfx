@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }

inline fun <X, Y> Manager<Node>.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data, init).add()