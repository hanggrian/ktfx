@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [BubbleChart] to this manager.
 *
 * @return the control added.
 */
fun <X, Y> NodeManager.bubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): BubbleChart<X, Y> = bubbleChart(x = x, y = y, data = data) { }

/**
 * Create a [BubbleChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <X, Y> bubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
  configuration: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(BubbleChart<X, Y>(x, y, data), configuration = configuration)
}

/**
 * Add a [BubbleChart] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <X, Y> NodeManager.bubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
  configuration: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(BubbleChart<X, Y>(x, y, data), configuration = configuration))
}

/**
 * Create a styled [BubbleChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <X, Y> styledBubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null
): BubbleChart<X, Y> = styledBubbleChart(x = x, y = y, data = data, styleClass = *styleClass, id =
    id) { }

/**
 * Add a styled [BubbleChart] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <X, Y> NodeManager.styledBubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null
): BubbleChart<X, Y> = styledBubbleChart(x = x, y = y, data = data, styleClass = *styleClass, id =
    id) { }

/**
 * Create a styled [BubbleChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <X, Y> styledBubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(BubbleChart<X, Y>(x, y, data), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [BubbleChart] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <X, Y> NodeManager.styledBubbleChart(
  x: Axis<X>,
  y: Axis<Y>,
  data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(BubbleChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
      configuration = configuration))
}
