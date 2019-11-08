@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [BubbleChart] with initialization block. */
inline fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: BubbleChart<X, Y>.() -> Unit
): BubbleChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return BubbleChart(x, y, data).apply(init)
}
/** Add a [BubbleChart] to this manager. */
fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList()
): BubbleChart<X, Y> = addNode(BubbleChart(x, y, data))

/** Add a [BubbleChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = FXCollections.observableArrayList(),
    init: BubbleChart<X, Y>.() -> Unit
): BubbleChart<X, Y> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(BubbleChart(x, y, data), init)
}
