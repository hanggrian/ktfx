@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.XYChart.Series
import javafxx.collections.mutableObservableListOf

/** Creates a [ScatterChart]. */
fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = ScatterChart(x, y, data).also {
    init?.invoke(it)
}

/** Creates a [ScatterChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = javafxx.layouts.scatterChart(x, y, data, init)()

/** Create a styled [ScatterChart]. */
fun <X, Y> styledScatterChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = ScatterChart(x, y, data).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ScatterChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.styledScatterChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null
): ScatterChart<X, Y> = javafxx.layouts.styledScatterChart(styleClass, x, y, data, init)()