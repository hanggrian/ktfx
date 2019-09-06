@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.concurrent.Task
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.TaskProgressView

/** Create a [TaskProgressView] with initialization block. */
inline fun <T : Task<*>> taskProgressView(
    init: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> = TaskProgressView<T>().apply(init)

/** Add a [TaskProgressView] to this manager. */
fun <T : Task<*>> NodeManager.taskProgressView(): TaskProgressView<T> =
    addNode(ktfx.controlsfx.taskProgressView { })

/** Add a [TaskProgressView] with initialization block to this manager. */
inline fun <T : Task<*>> NodeManager.taskProgressView(
    init: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> = addNode(ktfx.controlsfx.taskProgressView(init))
