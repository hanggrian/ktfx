@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [StackedBarChart]. */
fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null
): StackedBarChart<X, Y> = StackedBarChart(x, y, data).also {
    init?.invoke(it)
}

/** Creates a [StackedBarChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null
): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()

/** Create a styled [StackedBarChart]. */
fun <X, Y> styledStackedBarChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null
): StackedBarChart<X, Y> = StackedBarChart(x, y, data).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [StackedBarChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.styledStackedBarChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null
): StackedBarChart<X, Y> = ktfx.layouts.styledStackedBarChart(styleClass, x, y, data, init).add()