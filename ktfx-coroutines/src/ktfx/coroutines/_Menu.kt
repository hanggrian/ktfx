@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Menu
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
 * @see Menu.setOnShowing
 */
fun Menu.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see Menu.setOnShown
 */
fun Menu.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}

/**
 * @see Menu.setOnHiding
 */
fun Menu.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}

/**
 * @see Menu.setOnHidden
 */
fun Menu.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event ->
    GlobalScope.launch(context) {
        action(event)
    }
}
