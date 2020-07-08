@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.ContextMenu
import javafx.scene.control.Menu
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Called just prior to the [ContextMenu] being shown, even if the menu has no items to show. */
fun Menu.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ContextMenu] is shown. */
fun Menu.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [ContextMenu] being hidden. */
fun Menu.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ContextMenu] has been hidden. */
fun Menu.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }
