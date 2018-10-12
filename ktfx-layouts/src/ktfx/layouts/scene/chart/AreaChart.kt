@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series

/** Creates a [AreaChart]. */
fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = AreaChart(x, y, data).also { init?.invoke(it) }

/** Creates a [AreaChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init)()