@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import ktfx.collections.mutableObservableListOf

inline fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf()
): PieChart = pieChart(data) { }

inline fun pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDsl PieChart).() -> Unit
): PieChart = PieChart(data).apply(init)

inline fun LayoutManager<Node>.pieChart(
    data: ObservableList<Data> = mutableObservableListOf()
): PieChart = pieChart(data) { }

inline fun LayoutManager<Node>.pieChart(
    data: ObservableList<Data> = mutableObservableListOf(),
    init: (@LayoutDsl PieChart).() -> Unit
): PieChart = ktfx.layouts.pieChart(data, init).add()