@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Sets the JavaScript {@code alert} handler. */
fun WebEngine.onAlert(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
): Unit = setOnAlert { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the JavaScript status handler. */
fun WebEngine.onStatusChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
): Unit = setOnStatusChanged { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the JavaScript window resize handler. */
fun WebEngine.onResized(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
): Unit = setOnResized { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the JavaScript window visibility handler. */
fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
): Unit = setOnVisibilityChanged { event -> GlobalScope.launch(context) { action(event) } }

/** The event handler called when an error occurs. */
fun WebEngine.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
): Unit = setOnError { event -> GlobalScope.launch(context) { action(event) } }
