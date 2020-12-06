@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.XYChart
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [AreaChart] to this manager.
 *
 * @return the control added.
 */
public fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): AreaChart<X, Y> = areaChart(x = x, y = y, data = data) { }

/**
 * Create an [AreaChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <X, Y> areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = AreaChart<X, Y>(x, y, data)
    child.configuration()
    return child
}

/**
 * Add an [AreaChart] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <X, Y> NodeManager.areaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = AreaChart<X, Y>(x, y, data)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [AreaChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <X, Y> styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): AreaChart<X, Y> = styledAreaChart(x = x, y = y, data = data, styleClass = *styleClass, id = id) {
}

/**
 * Add a styled [AreaChart] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <X, Y> NodeManager.styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): AreaChart<X, Y> = styledAreaChart(x = x, y = y, data = data, styleClass = *styleClass, id = id) {
}

/**
 * Create a styled [AreaChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <X, Y> styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = AreaChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [AreaChart] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <X, Y> NodeManager.styledAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker AreaChart<X, Y>).() -> Unit
): AreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = AreaChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
