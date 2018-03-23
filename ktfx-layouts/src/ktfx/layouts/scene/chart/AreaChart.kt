@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()