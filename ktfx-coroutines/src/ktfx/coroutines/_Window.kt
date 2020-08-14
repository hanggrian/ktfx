@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.stage.Window
import javafx.stage.WindowEvent
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
 * @see Window.setOnCloseRequest
 */
fun Window.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnCloseRequest { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Window.setOnShowing
 */
fun Window.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnShowing { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Window.setOnShown
 */
fun Window.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnShown { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Window.setOnHiding
 */
fun Window.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnHiding { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see Window.setOnHidden
 */
fun Window.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnHidden { event ->
    GlobalScope.launch(context) { action(event) }
}
