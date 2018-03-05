package kotlinfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun WebEngine.onAlert(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnAlert { event -> launch(context) { action(event) } }

fun WebEngine.onError(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
) = setOnError { event -> launch(context) { action(event) } }

fun WebEngine.onResized(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
) = setOnResized { event -> launch(context) { action(event) } }

fun WebEngine.onStatusChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnStatusChanged { event -> launch(context) { action(event) } }

fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged { event -> launch(context) { action(event) } }