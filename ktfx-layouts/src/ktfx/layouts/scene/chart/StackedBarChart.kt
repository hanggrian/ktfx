@file:Suppress("PackageDirectoryMismatch")

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
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedBarChart<X, Y> = StackedBarChart(x, y, data)

/** Creates a [StackedBarChart] with initialization block. */
inline fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> = stackedBarChart(x, y, data).apply(init)

/** Creates and add a [StackedBarChart] to this manager. */
fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data).add()

/** Creates and add a [StackedBarChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()
