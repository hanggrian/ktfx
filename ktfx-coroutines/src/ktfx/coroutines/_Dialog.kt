@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Dialog.setOnShowing
 */
fun Dialog<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DialogEvent) -> Unit
) {
    return setOnShowing { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Dialog.setOnShown
 */
fun Dialog<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DialogEvent) -> Unit
) {
    return setOnShown { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Dialog.setOnHiding
 */
fun Dialog<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DialogEvent) -> Unit
) {
    return setOnHiding { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Dialog.setOnHidden
 */
fun Dialog<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DialogEvent) -> Unit
) {
    return setOnHidden { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Dialog.setOnCloseRequest
 */
fun Dialog<*>.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(DialogEvent) -> Unit
) {
    return setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }
}
