@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker
import kotlin.coroutines.CoroutineContext

fun JFXDrawer.onDrawerClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit
): Unit = setOnDrawerClosed { event -> GlobalScope.launch(context) { action(event) } }

fun JFXDrawer.onDrawerClosing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit
): Unit = setOnDrawerClosing { event -> GlobalScope.launch(context) { action(event) } }

fun JFXDrawer.onDrawerOpened(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit
): Unit = setOnDrawerOpened { event -> GlobalScope.launch(context) { action(event) } }

fun JFXDrawer.onDrawerOpening(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXDrawerEvent) -> Unit
): Unit = setOnDrawerOpening { event -> GlobalScope.launch(context) { action(event) } }

/** Creates a [JFXDrawer]. */
fun jfxDrawer(
    init: ((@LayoutMarker JFXDrawer).() -> Unit)? = null
): JFXDrawer = JFXDrawer().also { init?.invoke(it) }

/** Creates a [JFXDrawer] and add it to this manager. */
inline fun NodeManager.jfxDrawer(
    noinline init: ((@LayoutMarker JFXDrawer).() -> Unit)? = null
): JFXDrawer = ktfx.jfoenix.jfxDrawer(init).add()