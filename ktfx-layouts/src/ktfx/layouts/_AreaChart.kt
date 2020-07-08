@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [AreaChart] to this manager.
 */
fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): AreaChart<X, Y> = areaChart(x = x, y = y, data = data) { }

/**
 * Create an [AreaChart] with configuration block.
 */
inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(AreaChart<X, Y>(x, y, data), configuration = configuration)
}

/**
 * Add an [AreaChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(AreaChart<X, Y>(x, y, data), configuration = configuration))
}

/**
 * Create a styled [AreaChart].
 */
fun <X, Y> styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): AreaChart<X, Y> = styledAreaChart(x = x, y = y, data = data, styleClass = *styleClass, id = id) {
}

/**
 * Add a styled [AreaChart] to this manager.
 */
fun <X, Y> NodeManager.styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): AreaChart<X, Y> = styledAreaChart(x = x, y = y, data = data, styleClass = *styleClass, id = id) {
}

/**
 * Create a styled [AreaChart] with configuration block.
 */
inline fun <X, Y> styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        AreaChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [AreaChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            AreaChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
