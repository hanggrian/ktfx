@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [PieChart] with initialization block. */
inline fun pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList(),
    init: (@LayoutsDslMarker PieChart).() -> Unit
): PieChart {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return PieChart(data).apply(init)
}

/** Add a [PieChart] to this manager. */
fun NodeManager.pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList()
): PieChart = addChild(PieChart(data))

/** Add a [PieChart] with initialization block to this manager. */
inline fun NodeManager.pieChart(
    data: ObservableList<Data> = FXCollections.observableArrayList(),
    init: (@LayoutsDslMarker PieChart).() -> Unit
): PieChart {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(PieChart(data), init)
}
