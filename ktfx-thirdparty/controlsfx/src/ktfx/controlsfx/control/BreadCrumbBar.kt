@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.control.TreeItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.BreadCrumbBar
import kotlin.coroutines.CoroutineContext

fun <T> BreadCrumbBar<T>.onCrumbAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
): Unit = setOnCrumbAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Creates a [BreadCrumbBar]. */
fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: ((@LayoutDslMarker BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = BreadCrumbBar<T>(selectedCrumb).also { init?.invoke(it) }

/** Creates a [BreadCrumbBar] and add it to this manager. */
inline fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    noinline init: ((@LayoutDslMarker BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = ktfx.controlsfx.breadCrumbBar(selectedCrumb, init).add()