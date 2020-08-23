@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
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
 * @see MenuItem.setOnAction
 */
fun MenuItem.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ActionEvent) -> Unit
) {
    return setOnAction { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see MenuItem.setOnMenuValidation
 */
fun MenuItem.onMenuValidation(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnMenuValidation { event -> GlobalScope.launch(context) { action(event) } }
}
