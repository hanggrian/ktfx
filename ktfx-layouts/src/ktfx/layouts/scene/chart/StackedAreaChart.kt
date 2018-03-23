@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()