@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.concurrent.Task
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.TaskProgressView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TaskProgressView] to this manager.
 */
fun <T : Task<*>> NodeManager.taskProgressView(): TaskProgressView<T> = taskProgressView() { }

/**
 * Create a [TaskProgressView] with configuration block.
 */
inline fun <T : Task<*>> taskProgressView(
    configuration: (
        @LayoutDslMarker
        TaskProgressView<T>
    ).() -> Unit
): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TaskProgressView<T>(), configuration = configuration)
}

/**
 * Add a [TaskProgressView] with configuration block to this manager.
 */
inline fun <T : Task<*>> NodeManager.taskProgressView(
    configuration: (
        @LayoutDslMarker
        TaskProgressView<T>
    ).() -> Unit
): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TaskProgressView<T>(), configuration = configuration))
}

/**
 * Create a styled [TaskProgressView].
 */
fun <T : Task<*>> styledTaskProgressView(vararg styleClass: String, id: String? = null):
    TaskProgressView<T> = styledTaskProgressView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TaskProgressView] to this manager.
 */
fun <T : Task<*>> NodeManager.styledTaskProgressView(vararg styleClass: String, id: String? = null):
    TaskProgressView<T> = styledTaskProgressView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TaskProgressView] with configuration block.
 */
inline fun <T : Task<*>> styledTaskProgressView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        TaskProgressView<T>(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [TaskProgressView] with configuration block to this manager.
 */
inline fun <T : Task<*>> NodeManager.styledTaskProgressView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            TaskProgressView<T>(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
