@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.concurrent.Task
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutDsl
import org.controlsfx.control.TaskProgressView

/** Creates a [TaskProgressView]. */
fun <T : Task<*>> taskProgressView(
    init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = TaskProgressView<T>().also { init?.invoke(it) }

/** Creates a [TaskProgressView] and add it to this manager. */
inline fun <T : Task<*>> NodeInvokable.taskProgressView(
    noinline init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = ktfx.controlsfx.taskProgressView(init)()