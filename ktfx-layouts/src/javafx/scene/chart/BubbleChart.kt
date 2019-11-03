@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series

/** Create a [BubbleChart] with initialization block. */
inline fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> = BubbleChart(x, y, data).apply(init)

/** Add a [BubbleChart] to this manager. */
fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): BubbleChart<X, Y> = addNode(BubbleChart(x, y, data))

/** Add a [BubbleChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> = addNode(BubbleChart(x, y, data), init)
