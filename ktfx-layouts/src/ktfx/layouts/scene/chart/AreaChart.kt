@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates an [AreaChart]. */
fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): AreaChart<X, Y> = AreaChart(x, y, data)

/** Creates an [AreaChart] with initialization block. */
inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> = areaChart(x, y, data).apply(init)

/** Creates and add a [AreaChart] to this manager. */
fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data).add()

/** Creates and add a [AreaChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()
