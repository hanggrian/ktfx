@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see WebEngine.setOnAlert
 */
fun WebEngine.onAlert(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WebEvent<String>) -> Unit
) {
    return setOnAlert { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see WebEngine.setOnStatusChanged
 */
fun WebEngine.onStatusChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WebEvent<String>) -> Unit
) {
    return setOnStatusChanged { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see WebEngine.setOnResized
 */
fun WebEngine.onResized(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WebEvent<Rectangle2D>) -> Unit
) {
    return setOnResized { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see WebEngine.setOnVisibilityChanged
 */
fun WebEngine.onVisibilityChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WebEvent<Boolean>) -> Unit
) {
    return setOnVisibilityChanged { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see WebEngine.setOnError
 */
fun WebEngine.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WebErrorEvent) -> Unit
) {
    return setOnError { event -> GlobalScope.launch(context) { action(event) } }
}
