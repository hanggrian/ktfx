@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

/** Creates a [PieChart]. */
fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = PieChart(data).also {
    init?.invoke(it)
}

/** Creates a [PieChart] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = ktfx.layouts.pieChart(data, init)()

/** Create a styled [PieChart]. */
fun styledPieChart(
    styleClass: String,
    data: ObservableList<Data> = mutableObservableListOf(),
    init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = PieChart(data).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [PieChart] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPieChart(
    styleClass: String,
    data: ObservableList<Data> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = ktfx.layouts.styledPieChart(styleClass, data, init)()