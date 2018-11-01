@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [AreaChart]. */
fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = AreaChart(x, y, data).also { init?.invoke(it) }

/** Creates a [AreaChart] and add it to this manager. */
inline fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init)()