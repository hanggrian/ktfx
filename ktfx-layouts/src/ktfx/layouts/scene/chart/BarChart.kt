@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart.Series
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [BarChart]. */
fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0,
    init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = BarChart(x, y, data, gap).also { init?.invoke(it) }

/** Creates a [BarChart] and add it to this manager. */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    gap: Double = 10.0,
    noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init)()