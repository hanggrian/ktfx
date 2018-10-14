@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart.Series
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [StackedAreaChart]. */
fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).also { init?.invoke(it) }

/** Creates a [StackedAreaChart] and add it to this manager. */
inline fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init)()