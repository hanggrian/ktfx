@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the JavaScript {@code alert} handler. */
fun WebEngine.onAlert(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnAlert { event -> GlobalScope.launch(context) { action(event) } }

/** The event handler called when an error occurs. */
fun WebEngine.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
) = setOnError { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the JavaScript window resize handler. */
fun WebEngine.onResized(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
) = setOnResized { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the JavaScript status handler. */
fun WebEngine.onStatusChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnStatusChanged { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the JavaScript window visibility handler. */
fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged { event -> GlobalScope.launch(context) { action(event) } }