@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

/** Create a [PieChart] with initialization block. */
inline fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDslMarker PieChart).() -> Unit
): PieChart = PieChart(data).apply(init)

/** Add a [PieChart] to this manager. */
fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf()
): PieChart = addNode(ktfx.layouts.pieChart(data) { })

/** Add a [PieChart] with initialization block to this manager. */
inline fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDslMarker PieChart).() -> Unit
): PieChart = addNode(ktfx.layouts.pieChart(data, init))
