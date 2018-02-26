@file:JvmMultifileClass
@file:JvmName("EventsKt")

package kotfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun WebEngine.onAlert(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnAlert { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun WebEngine.onError(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
) = setOnError { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun WebEngine.onResized(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
) = setOnResized { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun WebEngine.onStatusChanged(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnStatusChanged { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}