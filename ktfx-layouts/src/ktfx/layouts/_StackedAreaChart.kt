@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [StackedAreaChart] to this manager.
 *
 * @return the control added.
 */
public fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): StackedAreaChart<X, Y> = stackedAreaChart(x = x, y = y, data = data) { }

/**
 * Create a [StackedAreaChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedAreaChart<X, Y>(x, y, data)
    child.configuration()
    return child
}

/**
 * Add a [StackedAreaChart] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedAreaChart<X, Y>(x, y, data)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [StackedAreaChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <X, Y> styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): StackedAreaChart<X, Y> = styledStackedAreaChart(
    x = x, y = y, data = data,
    styleClass =
    *styleClass,
    id = id
) { }

/**
 * Add a styled [StackedAreaChart] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <X, Y> NodeManager.styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): StackedAreaChart<X, Y> = styledStackedAreaChart(
    x = x, y = y, data = data,
    styleClass =
    *styleClass,
    id = id
) { }

/**
 * Create a styled [StackedAreaChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <X, Y> styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedAreaChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [StackedAreaChart] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <X, Y> NodeManager.styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StackedAreaChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
