@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.control.TreeItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.NodeInvokable
import ktfx.LayoutDsl
import org.controlsfx.control.BreadCrumbBar
import kotlin.coroutines.CoroutineContext

fun <T> BreadCrumbBar<T>.onCrumbAction(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
): Unit = setOnCrumbAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Creates a [BreadCrumbBar]. */
fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = BreadCrumbBar<T>(selectedCrumb).also { init?.invoke(it) }

/** Creates a [BreadCrumbBar] and add it to this manager. */
inline fun <T> NodeInvokable.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = ktfx.controlsfx.breadCrumbBar(selectedCrumb, init)()