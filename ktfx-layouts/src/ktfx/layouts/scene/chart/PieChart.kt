@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

/** Creates a [PieChart]. */
fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: ((@LayoutMarker PieChart).() -> Unit)? = null
): PieChart = PieChart(data).also { init?.invoke(it) }

/** Creates a [PieChart] and add it to this manager. */
inline fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    noinline init: ((@LayoutMarker PieChart).() -> Unit)? = null
): PieChart = ktfx.layouts.pieChart(data, init).add()