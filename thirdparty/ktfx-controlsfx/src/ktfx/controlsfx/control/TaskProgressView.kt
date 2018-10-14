@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.concurrent.Task
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.TaskProgressView

/** Creates a [TaskProgressView]. */
fun <T : Task<*>> taskProgressView(
    init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = TaskProgressView<T>().also { init?.invoke(it) }

/** Creates a [TaskProgressView] and add it to this manager. */
inline fun <T : Task<*>> NodeManager.taskProgressView(
    noinline init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = ktfx.controlsfx.taskProgressView(init)()