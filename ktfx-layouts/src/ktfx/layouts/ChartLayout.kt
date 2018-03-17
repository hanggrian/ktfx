@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.PieChart
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = ktfx.layouts.areaChart(x, y, data, init).add()

inline fun <X, Y> barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()
inline fun <X, Y> ItemManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()
inline fun <X, Y> ButtonManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@LayoutDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = ktfx.layouts.barChart(x, y, data, gap, init).add()

inline fun <X, Y> bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()

inline fun pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }
inline fun ChildManager.pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = ktfx.layouts.pieChart(data, init).add()
inline fun ItemManager.pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = ktfx.layouts.pieChart(data, init).add()
inline fun ButtonManager.pieChart(data: ObservableList<PieChart.Data> = mutableObservableListOf(), noinline init: ((@LayoutDsl PieChart).() -> Unit)? = null): PieChart = ktfx.layouts.pieChart(data, init).add()

inline fun <X, Y> scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ktfx.layouts.scatterChart(x, y, data, init).add()

inline fun <X, Y> stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = ktfx.layouts.stackedAreaChart(x, y, data, init).add()

inline fun <X, Y> stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = ktfx.layouts.stackedBarChart(x, y, data, init).add()