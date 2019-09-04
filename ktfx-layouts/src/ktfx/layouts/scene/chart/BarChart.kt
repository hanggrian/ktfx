@file:Suppress("PackageDirectoryMismatch")

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
    gap: Number = 10
): BarChart<X, Y> = BarChart(x, y, data, gap.toDouble())

/** Creates a [BarChart] with initialization block. */
inline fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10,
    init: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> = barChart(x, y, data, gap).apply(init)

/** Creates and add a [BarChart] to this manager. */
fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap).add()

/** Creates and add a [BarChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    gap: Number = 10,
    init: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()
