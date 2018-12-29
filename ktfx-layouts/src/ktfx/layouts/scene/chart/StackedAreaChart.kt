@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [StackedAreaChart]. */
fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutMarker StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).also { init?.invoke(it) }

/** Creates a [StackedAreaChart] and add it to this manager. */
inline fun <X, Y> NodeInvokable.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutMarker StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init)()