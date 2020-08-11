@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.ScatterChart
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
 * Add a [ScatterChart] to this manager.
 *
 * @return the control added.
 */
fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): ScatterChart<X, Y> = scatterChart(x = x, y = y, data = data) { }

/**
 * Create a [ScatterChart] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <X, Y> scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ScatterChart<X, Y>(x, y, data), configuration = configuration)
}

/**
 * Add a [ScatterChart] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <X, Y> NodeManager.scatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ScatterChart<X, Y>(x, y, data), configuration = configuration))
}

/**
 * Create a styled [ScatterChart].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <X, Y> styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): ScatterChart<X, Y> = styledScatterChart(
    x = x, y = y, data = data, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [ScatterChart] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <X, Y> NodeManager.styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): ScatterChart<X, Y> = styledScatterChart(
    x = x, y = y, data = data, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [ScatterChart] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <X, Y> styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ScatterChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ScatterChart] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <X, Y> NodeManager.styledScatterChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ScatterChart<X, Y>).() -> Unit
): ScatterChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ScatterChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
