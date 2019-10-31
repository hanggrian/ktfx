@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Create an [AreaChart] with initialization block. */
inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> = AreaChart(x, y, data).apply(init)

/** Add an [AreaChart] to this manager. */
fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): AreaChart<X, Y> = addNode(AreaChart(x, y, data))

/** Add an [AreaChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> = addNode(AreaChart(x, y, data), init)
