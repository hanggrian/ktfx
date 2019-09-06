@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

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

/** Create a [JFXDrawer] with initialization block. */
inline fun jfxDrawer(
    init: (@LayoutDslMarker JFXDrawer).() -> Unit
): JFXDrawer = JFXDrawer().apply(init)

/** Add a [JFXDrawer] to this manager. */
fun NodeManager.jfxDrawer(): JFXDrawer =
    addNode(ktfx.jfoenix.jfxDrawer { })

/** Add a [JFXDrawer] with initialization block to this manager. */
inline fun NodeManager.jfxDrawer(
    init: (@LayoutDslMarker JFXDrawer).() -> Unit
): JFXDrawer = addNode(ktfx.jfoenix.jfxDrawer(init))
