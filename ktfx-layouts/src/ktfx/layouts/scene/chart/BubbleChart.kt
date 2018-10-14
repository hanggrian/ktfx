@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [BubbleChart]. */
fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = BubbleChart(x, y, data).also { init?.invoke(it) }

/** Creates a [BubbleChart] and add it to this manager. */
inline fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init)()