@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

inline fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = PieChart(data).apply { init?.invoke(this) }

inline fun Manager<Node>.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null
): PieChart = ktfx.layouts.pieChart(data, init).add()