@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [StackedBarChart]. */
fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit)? = null
): StackedBarChart<X, Y> = StackedBarChart(x, y, data).also { init?.invoke(it) }

/** Creates a [StackedBarChart] and add it to this manager. */
inline fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit)? = null
): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()
