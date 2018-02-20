@file:JvmMultifileClass
@file:JvmName("EventHandlersKt")

package kotfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun WebEngine.onAlert(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnAlert { event -> launch(context) { action(event) } }

fun WebEngine.onError(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(WebErrorEvent) -> Unit
) = setOnError { event -> launch(context) { action(event) } }

fun WebEngine.onResized(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
) = setOnResized { event -> launch(context) { action(event) } }

fun WebEngine.onStatusChanged(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(WebEvent<String>) -> Unit
) = setOnStatusChanged { event -> launch(context) { action(event) } }

fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged { event -> launch(context) { action(event) } }