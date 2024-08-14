@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [StackedBarChart] to this container.
 *
 * @return the control added.
 */
public inline fun <X, Y> NodeContainer.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
): StackedBarChart<X, Y> = stackedBarChart(x = x, y = y, data = data) { }

/**
 * Create a [StackedBarChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker StackedBarChart<X, Y>).() -> Unit,
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedBarChart<X, Y>(x, y, data)
    child.configuration()
    return child
}

/**
 * Add a [StackedBarChart] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun <X, Y> NodeContainer.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker StackedBarChart<X, Y>).() -> Unit,
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedBarChart<X, Y>(x, y, data)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [StackedBarChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <X, Y> styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): StackedBarChart<X, Y> = styledStackedBarChart(x = x, y = y, data = data, styleClass = styleClass,
        id = id) { }

/**
 * Add a styled [StackedBarChart] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <X, Y> NodeContainer.styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): StackedBarChart<X, Y> = styledStackedBarChart(x = x, y = y, data = data, styleClass = styleClass,
        id = id) { }

/**
 * Create a styled [StackedBarChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun <X, Y> styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker StackedBarChart<X, Y>).() -> Unit,
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedBarChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [StackedBarChart] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun <X, Y> NodeContainer.styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker StackedBarChart<X, Y>).() -> Unit,
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedBarChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
