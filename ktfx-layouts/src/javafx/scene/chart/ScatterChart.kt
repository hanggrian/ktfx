@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.XYChart.Series

/** Create a [ScatterChart] with initialization block. */
inline fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> = ScatterChart(x, y, data).apply(init)

/** Add a [ScatterChart] to this manager. */
fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): ScatterChart<X, Y> = addNode(ScatterChart(x, y, data))

/** Add a [ScatterChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> = addNode(ScatterChart(x, y, data), init)
