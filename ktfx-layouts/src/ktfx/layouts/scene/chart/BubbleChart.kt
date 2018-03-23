@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart
import ktfx.collections.mutableObservableListOf

inline fun <X, Y> bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()
inline fun <X, Y> ItemManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()
inline fun <X, Y> ButtonManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<XYChart.Series<X, Y>> = mutableObservableListOf(), noinline init: ((@LayoutDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = ktfx.layouts.bubbleChart(x, y, data, init).add()