@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.event.Event
import javafx.scene.Node
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.LayoutDsl
import ktfx.NodeManager
import org.controlsfx.control.NotificationPane
import kotlin.coroutines.CoroutineContext

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

    override fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [NotificationPane]. */
fun notificationPane(
    init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = _NotificationPane().also { init?.invoke(it) }

/** Creates a [NotificationPane] and add it to this manager. */
inline fun NodeManager.notificationPane(
    noinline init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = ktfx.controlsfx.notificationPane(init)()