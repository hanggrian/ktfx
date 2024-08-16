@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
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
 * Add a [ScatterChart] to this container.
 *
 * @return the control added.
 */
public inline fun <X, Y> NodeContainer.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
): ScatterChart<X, Y> = scatterChart(x = x, y = y, data = data) { }

/**
 * Create a [ScatterChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker ScatterChart<X, Y>).() -> Unit,
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScatterChart<X, Y>(x, y, data)
    child.configuration()
    return child
}

/**
 * Add a [ScatterChart] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <X, Y> NodeContainer.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker ScatterChart<X, Y>).() -> Unit,
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScatterChart<X, Y>(x, y, data)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ScatterChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <X, Y> styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): ScatterChart<X, Y> = styledScatterChart(x = x, y = y, data = data, styleClass = styleClass, id =
        id) { }

/**
 * Add a styled [ScatterChart] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <X, Y> NodeContainer.styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): ScatterChart<X, Y> = styledScatterChart(x = x, y = y, data = data, styleClass = styleClass, id =
        id) { }

/**
 * Create a styled [ScatterChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <X, Y> styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ScatterChart<X, Y>).() -> Unit,
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScatterChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ScatterChart] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <X, Y> NodeContainer.styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    `data`: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ScatterChart<X, Y>).() -> Unit,
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScatterChart<X, Y>(x, y, data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
