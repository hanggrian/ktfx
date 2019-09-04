@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

/** Add a [PieChart] to this manager. */
fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf()
): PieChart = PieChart(data).add()

/** Add a [PieChart] with initialization block to this manager. */
inline fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDslMarker PieChart).() -> Unit
): PieChart = pieChart(data).apply(init)
