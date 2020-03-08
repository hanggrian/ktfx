@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [BarChart] to this manager.
 */
fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0
): BarChart<X, Y> = barChart(x = x, y = y, data = data, categoryGap = categoryGap) { }

/**
 * Create a [BarChart] with configuration block.
 */
inline fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    configuration: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(BarChart<X, Y>(x, y, data, categoryGap), configuration = configuration)
}

/**
 * Add a [BarChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    configuration: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(BarChart<X, Y>(x, y, data, categoryGap), configuration =
            configuration))
}

/**
 * Create a styled [BarChart].
 */
fun <X, Y> styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null
): BarChart<X, Y> = styledBarChart(x = x, y = y, data = data, categoryGap = categoryGap, styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [BarChart] to this manager.
 */
fun <X, Y> NodeManager.styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null
): BarChart<X, Y> = styledBarChart(x = x, y = y, data = data, categoryGap = categoryGap, styleClass =
        *styleClass, id = id) { }

/**
 * Create a styled [BarChart] with configuration block.
 */
inline fun <X, Y> styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(BarChart<X, Y>(x, y, data, categoryGap), styleClass = *styleClass, id = id,
            configuration = configuration)
}

/**
 * Add a styled [BarChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker BarChart<X, Y>).() -> Unit
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(BarChart<X, Y>(x, y, data, categoryGap), styleClass = *styleClass, id =
            id, configuration = configuration))
}
