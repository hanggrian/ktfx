@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.concurrent.Task
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.TaskProgressView

/** Creates a [TaskProgressView]. */
fun <T : Task<*>> taskProgressView(
    init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = TaskProgressView<T>().also {
    init?.invoke(it)
}

/** Creates a [TaskProgressView] and add it to this [LayoutManager]. */
inline fun <T : Task<*>> LayoutManager<Node>.taskProgressView(
    noinline init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = ktfx.controlsfx.taskProgressView(init)()