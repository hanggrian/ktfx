@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PieChart] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.pieChart(`data`: ObservableList<PieChart.Data> =
        observableArrayList()): PieChart = pieChart(data = data) { }

/**
 * Create a [PieChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun pieChart(`data`: ObservableList<PieChart.Data> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker PieChart).() -> Unit): PieChart {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PieChart(data)
    child.configuration()
    return child
}

/**
 * Add a [PieChart] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.pieChart(`data`: ObservableList<PieChart.Data> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker PieChart).() -> Unit): PieChart {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PieChart(data)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [PieChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledPieChart(
    `data`: ObservableList<PieChart.Data> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): PieChart = styledPieChart(data = data, styleClass = styleClass, id = id) { }

/**
 * Add a styled [PieChart] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPieChart(
    `data`: ObservableList<PieChart.Data> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): PieChart = styledPieChart(data = data, styleClass = styleClass, id = id) { }

/**
 * Create a styled [PieChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledPieChart(
    `data`: ObservableList<PieChart.Data> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PieChart).() -> Unit,
): PieChart {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PieChart(data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PieChart] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledPieChart(
    `data`: ObservableList<PieChart.Data> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PieChart).() -> Unit,
): PieChart {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PieChart(data)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
