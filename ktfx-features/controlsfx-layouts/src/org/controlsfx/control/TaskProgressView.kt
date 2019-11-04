@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.concurrent.Task
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.TaskProgressView

/** Create a [TaskProgressView] with initialization block. */
inline fun <T : Task<*>> taskProgressView(
    init: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return TaskProgressView<T>().apply(init)
}
/** Add a [TaskProgressView] to this manager. */
fun <T : Task<*>> NodeManager.taskProgressView(): TaskProgressView<T> =
    addNode(TaskProgressView())

/** Add a [TaskProgressView] with initialization block to this manager. */
inline fun <T : Task<*>> NodeManager.taskProgressView(
    init: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(TaskProgressView(), init)
}
