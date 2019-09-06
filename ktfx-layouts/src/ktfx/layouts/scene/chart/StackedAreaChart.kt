@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Create a [StackedAreaChart] with initialization block. */
inline fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply(init)

/** Add a [StackedAreaChart] to this manager. */
fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): StackedAreaChart<X, Y> = addNode(ktfx.layouts.stackedAreaChart(x, y, data) { })

/** Add a [StackedAreaChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> = addNode(ktfx.layouts.stackedAreaChart(x, y, data, init))
