@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.scene.control.TreeItem
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.BreadCrumbBar

fun <T> BreadCrumbBar<T>.onCrumbAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
): Unit = setOnCrumbAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Add a [BreadCrumbBar] to this manager. */
fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null
): BreadCrumbBar<T> = BreadCrumbBar(selectedCrumb).add()

/** Add a [BreadCrumbBar] with initialization block to this manager. */
inline fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> = breadCrumbBar(selectedCrumb).apply(init)
