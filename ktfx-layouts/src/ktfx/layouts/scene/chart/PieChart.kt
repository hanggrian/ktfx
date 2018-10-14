@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [PieChart]. */
fun pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = PieChart(data).also { init?.invoke(it) }

/** Creates a [PieChart] and add it to this manager. */
inline fun NodeManager.pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = ktfx.layouts.pieChart(data, init)()