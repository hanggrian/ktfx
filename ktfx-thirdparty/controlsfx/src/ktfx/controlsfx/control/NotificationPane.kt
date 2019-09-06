@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.controlsfx

import javafx.event.Event
import javafx.scene.Node
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.NotificationPane

fun NotificationPane.onShowing(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

fun NotificationPane.onShown(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

fun NotificationPane.onHiding(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

fun NotificationPane.onHidden(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

open class _NotificationPane : NotificationPane(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { content = it }
}

/** Create a [NotificationPane] with initialization block. */
inline fun notificationPane(
    init: (@LayoutDslMarker _NotificationPane).() -> Unit
): NotificationPane = _NotificationPane().apply(init)

/** Add a [NotificationPane] to this manager. */
fun NodeManager.notificationPane(): NotificationPane =
    addNode(ktfx.controlsfx.notificationPane { })

/** Add a [NotificationPane] with initialization block to this manager. */
inline fun NodeManager.notificationPane(
    init: (@LayoutDslMarker _NotificationPane).() -> Unit
): NotificationPane = addNode(ktfx.controlsfx.notificationPane(init))
