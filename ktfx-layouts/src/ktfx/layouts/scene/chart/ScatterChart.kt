@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.XYChart.Series
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [ScatterChart]. */
fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = ScatterChart(x, y, data).also { init?.invoke(it) }

/** Creates a [ScatterChart] and add it to this manager. */
inline fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data, init)()