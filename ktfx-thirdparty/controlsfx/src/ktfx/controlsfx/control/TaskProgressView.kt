@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.concurrent.Task
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.TaskProgressView

/** Add a [TaskProgressView] to this manager. */
fun <T : Task<*>> NodeManager.taskProgressView(): TaskProgressView<T> =
    TaskProgressView<T>().add()

/** Add a [TaskProgressView] with initialization block to this manager. */
inline fun <T : Task<*>> NodeManager.taskProgressView(
    init: (@LayoutDslMarker TaskProgressView<T>).() -> Unit
): TaskProgressView<T> = taskProgressView<T>().apply(init)
