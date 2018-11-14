@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data

/** Creates a [PieChart]. */
fun pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = PieChart(data).also { init?.invoke(it) }

/** Creates a [PieChart] and add it to this manager. */
inline fun NodeInvokable.pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = ktfx.layouts.pieChart(data, init)()