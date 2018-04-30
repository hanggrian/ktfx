@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [BarChart]. */
fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = BarChart(x, y, data, gap).also {
    init?.invoke(it)
}

/** Creates a [BarChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()

/** Create a styled [BarChart]. */
fun <X, Y> styledBarChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = BarChart(x, y, data, gap).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [BarChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.styledBarChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = ktfx.layouts.styledBarChart(styleClass, x, y, data, gap, init).add()