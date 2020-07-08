@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedBarChart
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
 * Add a [StackedBarChart] to this manager.
 */
fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): StackedBarChart<X, Y> = stackedBarChart(x = x, y = y, data = data) { }

/**
 * Create a [StackedBarChart] with configuration block.
 */
inline fun <X, Y> stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(StackedBarChart<X, Y>(x, y, data), configuration = configuration)
}

/**
 * Add a [StackedBarChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.stackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(StackedBarChart<X, Y>(x, y, data), configuration = configuration))
}

/**
 * Create a styled [StackedBarChart].
 */
fun <X, Y> styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): StackedBarChart<X, Y> = styledStackedBarChart(
    x = x, y = y, data = data,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [StackedBarChart] to this manager.
 */
fun <X, Y> NodeManager.styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): StackedBarChart<X, Y> = styledStackedBarChart(
    x = x, y = y, data = data,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Create a styled [StackedBarChart] with configuration block.
 */
inline fun <X, Y> styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        StackedBarChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [StackedBarChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.styledStackedBarChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker StackedBarChart<X, Y>).() -> Unit
): StackedBarChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            StackedBarChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
