@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [ScatterChart]. */
fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): ScatterChart<X, Y> = ScatterChart(x, y, data)

/** Creates a [ScatterChart] with initialization block. */
inline fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> = scatterChart(x, y, data).apply(init)

/** Creates and add a [ScatterChart] to this manager. */
fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data).add()

/** Creates and add a [ScatterChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data, init).add()
