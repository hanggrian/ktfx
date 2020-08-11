@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.PieChart
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [PieChart] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.pieChart(data: ObservableList<PieChart.Data> = observableArrayList()): PieChart =
    pieChart(data = data) { }

/**
 * Create a [PieChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun pieChart(data: ObservableList<PieChart.Data> = observableArrayList(),
    configuration: (@LayoutDslMarker PieChart).() -> Unit): PieChart {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(PieChart(data), configuration = configuration)
}

/**
 * Add a [PieChart] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.pieChart(data: ObservableList<PieChart.Data> = observableArrayList(),
    configuration: (@LayoutDslMarker PieChart).() -> Unit): PieChart {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(PieChart(data), configuration = configuration))
}

/**
 * Create a styled [PieChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledPieChart(
  data: ObservableList<PieChart.Data> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null
): PieChart = styledPieChart(data = data, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PieChart] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledPieChart(
  data: ObservableList<PieChart.Data> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null
): PieChart = styledPieChart(data = data, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PieChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledPieChart(
  data: ObservableList<PieChart.Data> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker PieChart).() -> Unit
): PieChart {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(PieChart(data), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [PieChart] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledPieChart(
  data: ObservableList<PieChart.Data> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker PieChart).() -> Unit
): PieChart {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(PieChart(data), styleClass = *styleClass, id = id, configuration =
      configuration))
}
