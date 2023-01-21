@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import javafx.concurrent.Task
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.TaskProgressView

/**
 * Add a [TaskProgressView] to this manager.
 *
 * @return the control added.
 */
public fun <T : Task<*>> NodeManager.taskProgressView(): TaskProgressView<T> = taskProgressView() {
        }

/**
 * Create a [TaskProgressView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T : Task<*>> taskProgressView(configuration: (@KtfxLayoutDslMarker
        TaskProgressView<T>).() -> Unit): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TaskProgressView<T>()
    child.configuration()
    return child
}

/**
 * Add a [TaskProgressView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T : Task<*>> NodeManager.taskProgressView(configuration: (@KtfxLayoutDslMarker
        TaskProgressView<T>).() -> Unit): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TaskProgressView<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TaskProgressView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun <T : Task<*>> styledTaskProgressView(vararg styleClass: String, id: String? = null):
        TaskProgressView<T> = styledTaskProgressView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TaskProgressView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun <T : Task<*>> NodeManager.styledTaskProgressView(vararg styleClass: String, id: String? =
        null): TaskProgressView<T> = styledTaskProgressView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TaskProgressView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T : Task<*>> styledTaskProgressView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TaskProgressView<T>).() -> Unit,
): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TaskProgressView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TaskProgressView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T : Task<*>> NodeManager.styledTaskProgressView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TaskProgressView<T>).() -> Unit,
): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TaskProgressView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
