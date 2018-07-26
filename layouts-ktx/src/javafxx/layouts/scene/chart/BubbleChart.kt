@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series
import javafxx.collections.mutableObservableListOf

/** Creates a [BubbleChart]. */
fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = BubbleChart(x, y, data).also {
    init?.invoke(it)
}

/** Creates a [BubbleChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = javafxx.layouts.bubbleChart(x, y, data, init)()

/** Create a styled [BubbleChart]. */
fun <X, Y> styledBubbleChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = BubbleChart(x, y, data).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [BubbleChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.styledBubbleChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null
): BubbleChart<X, Y> = javafxx.layouts.styledBubbleChart(styleClass, x, y, data, init)()