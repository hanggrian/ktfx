@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")

package ktfx.thirdparty.jfoenix.coroutines

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

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
