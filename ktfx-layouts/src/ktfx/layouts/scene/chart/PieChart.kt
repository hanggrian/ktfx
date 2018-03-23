@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import ktfx.collections.mutableObservableListOf

inline fun pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }
inline fun ChildManager.pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = ktfx.layouts.pieChart(data, init).add()
inline fun ItemManager.pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = ktfx.layouts.pieChart(data, init).add()
inline fun ButtonManager.pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = ktfx.layouts.pieChart(data, init).add()