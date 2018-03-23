@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()
inline fun <X, Y> ItemManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()
inline fun <X, Y> ButtonManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()