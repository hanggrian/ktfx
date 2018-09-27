@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

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
): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init)()