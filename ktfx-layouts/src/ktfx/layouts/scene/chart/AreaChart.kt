@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [AreaChart]. */
fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = AreaChart(x, y, data).also {
    init?.invoke(it)
}

/** Creates a [AreaChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init)()

/** Create a styled [AreaChart]. */
fun <X, Y> styledAreaChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = AreaChart(x, y, data).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [AreaChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.styledAreaChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = ktfx.layouts.styledAreaChart(styleClass, x, y, data, init)()