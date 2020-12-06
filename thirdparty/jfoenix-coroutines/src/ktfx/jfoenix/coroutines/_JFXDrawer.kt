@file:JvmMultifileClass
@file:JvmName("JFoenixCoroutinesKt")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
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
 * @see JFXDrawer.setOnDrawerClosed
 */
public fun JFXDrawer.onDrawerClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(JFXDrawerEvent) -> Unit
) {
    return setOnDrawerClosed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see JFXDrawer.setOnDrawerClosing
 */
public fun JFXDrawer.onDrawerClosing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(JFXDrawerEvent) -> Unit
) {
    return setOnDrawerClosing { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see JFXDrawer.setOnDrawerOpened
 */
public fun JFXDrawer.onDrawerOpened(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(JFXDrawerEvent) -> Unit
) {
    return setOnDrawerOpened { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see JFXDrawer.setOnDrawerOpening
 */
public fun JFXDrawer.onDrawerOpening(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(JFXDrawerEvent) -> Unit
) {
    return setOnDrawerOpening { event -> GlobalScope.launch(context) { action(event) } }
}
