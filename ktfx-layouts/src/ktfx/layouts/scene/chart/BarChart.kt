@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart.Series

/** Creates a [BarChart]. */
fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0,
    init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = BarChart(x, y, data, gap).also { init?.invoke(it) }

/** Creates a [BarChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0,
    noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init)()