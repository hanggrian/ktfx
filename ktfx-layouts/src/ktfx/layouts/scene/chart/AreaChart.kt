@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
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
): AreaChart<X, Y> = AreaChart(x, y, data).also { init?.invoke(it) }

/** Creates a [AreaChart] and add it to this manager. */
inline fun <X, Y> NodeInvokable.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init)()