@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.XYChart
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [BarChart] to this manager.
 *
 * @return the control added.
 */
public fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
): BarChart<X, Y> = barChart(x = x, y = y, data = data, categoryGap = categoryGap) { }

/**
 * Create a [BarChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <X, Y> barChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    configuration: (@KtfxLayoutDslMarker BarChart<X, Y>).() -> Unit,
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BarChart<X, Y>(x, y, data, categoryGap)
    child.configuration()
    return child
}

/**
 * Add a [BarChart] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <X, Y> NodeManager.barChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    configuration: (@KtfxLayoutDslMarker BarChart<X, Y>).() -> Unit,
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BarChart<X, Y>(x, y, data, categoryGap)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [BarChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <X, Y> styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null,
): BarChart<X, Y> = styledBarChart(x = x, y = y, data = data, categoryGap = categoryGap, styleClass
        = *styleClass, id = id) { }

/**
 * Add a styled [BarChart] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <X, Y> NodeManager.styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null,
): BarChart<X, Y> = styledBarChart(x = x, y = y, data = data, categoryGap = categoryGap, styleClass
        = *styleClass, id = id) { }

/**
 * Create a styled [BarChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <X, Y> styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker BarChart<X, Y>).() -> Unit,
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BarChart<X, Y>(x, y, data, categoryGap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [BarChart] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <X, Y> NodeManager.styledBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    categoryGap: Double = 10.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker BarChart<X, Y>).() -> Unit,
): BarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BarChart<X, Y>(x, y, data, categoryGap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
