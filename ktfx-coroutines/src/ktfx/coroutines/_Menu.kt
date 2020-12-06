@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

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
public fun Menu.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnShowing { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Menu.setOnShown
 */
public fun Menu.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnShown { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Menu.setOnHiding
 */
public fun Menu.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnHiding { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see Menu.setOnHidden
 */
public fun Menu.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(Event) -> Unit
) {
    return setOnHidden { event -> GlobalScope.launch(context) { action(event) } }
}
