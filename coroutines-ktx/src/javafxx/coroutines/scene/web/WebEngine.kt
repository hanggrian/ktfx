@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the JavaScript {@code alert} handler. */
fun WebEngine.onAlert(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnAlert { event -> launch(context) { action(event) } }

/** The event handler called when an error occurs. */
fun WebEngine.onError(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
) = setOnError { event -> launch(context) { action(event) } }

/** Sets the JavaScript window resize handler. */
fun WebEngine.onResized(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
) = setOnResized { event -> launch(context) { action(event) } }

/** Sets the JavaScript status handler. */
fun WebEngine.onStatusChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnStatusChanged { event -> launch(context) { action(event) } }

/** Sets the JavaScript window visibility handler. */
fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged { event -> launch(context) { action(event) } }