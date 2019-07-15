@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
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
    init: ((@LayoutDslMarker BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = BarChart(x, y, data, gap).also { init?.invoke(it) }

/** Creates a [BarChart] and add it to this manager. */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Double = 10.0,
    noinline init: ((@LayoutDslMarker BarChart<X, Y>).() -> Unit)? = null
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()
