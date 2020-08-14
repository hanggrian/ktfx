@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
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
 * @see Tab.setOnSelectionChanged
 */
fun Tab.onSelectionChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnSelectionChanged { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Tab.setOnClosed
 */
fun Tab.onClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnClosed { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}

/**
 * @see Tab.setOnCloseRequest
 */
fun Tab.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnCloseRequest { event ->
    GlobalScope.launch(context) { action(event) }
}
