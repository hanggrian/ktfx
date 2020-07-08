@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
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
 * Add a [StackedAreaChart] to this manager.
 */
fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList()
): StackedAreaChart<X, Y> = stackedAreaChart(x = x, y = y, data = data) { }

/**
 * Create a [StackedAreaChart] with configuration block.
 */
inline fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(StackedAreaChart<X, Y>(x, y, data), configuration = configuration)
}

/**
 * Add a [StackedAreaChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    configuration: (@LayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(StackedAreaChart<X, Y>(x, y, data), configuration = configuration))
}

/**
 * Create a styled [StackedAreaChart].
 */
fun <X, Y> styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
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
 */
fun <X, Y> NodeManager.styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
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
 */
inline fun <X, Y> styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        StackedAreaChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [StackedAreaChart] with configuration block to this manager.
 */
inline fun <X, Y> NodeManager.styledStackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<XYChart.Series<X, Y>> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker StackedAreaChart<X, Y>).() -> Unit
): StackedAreaChart<X, Y> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            StackedAreaChart<X, Y>(x, y, data), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
