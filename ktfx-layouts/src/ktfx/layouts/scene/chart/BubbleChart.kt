@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Creates a [BubbleChart]. */
fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutMarker BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = BubbleChart(x, y, data).also { init?.invoke(it) }

/** Creates a [BubbleChart] and add it to this manager. */
inline fun <X, Y> NodeInvokable.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutMarker BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init)()