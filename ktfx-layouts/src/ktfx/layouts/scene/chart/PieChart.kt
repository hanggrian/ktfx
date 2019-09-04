@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

/** Creates a [PieChart]. */
fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf()
): PieChart = PieChart(data)

/** Creates a [PieChart] with initialization block. */
inline fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDslMarker PieChart).() -> Unit
): PieChart = pieChart(data).apply(init)

/** Creates and add a [PieChart] to this manager. */
fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf()
): PieChart = ktfx.layouts.pieChart(data).add()

/** Creates and add a [PieChart] with initialization block to this manager. */
inline fun NodeManager.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDslMarker PieChart).() -> Unit
): PieChart = ktfx.layouts.pieChart(data, init).add()
