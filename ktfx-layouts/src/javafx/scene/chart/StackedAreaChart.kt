@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart.Series
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [StackedAreaChart] with initialization block. */
inline fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@KtfxLayoutsDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return StackedAreaChart(x, y, data).apply(init)
}

/** Add a [StackedAreaChart] to this manager. */
fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): StackedAreaChart<X, Y> = addNode(StackedAreaChart(x, y, data))

/** Add a [StackedAreaChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: (@KtfxLayoutsDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(StackedAreaChart(x, y, data), init)
}
