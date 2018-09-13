@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.scene.control.ContextMenu
import javafx.scene.control.Menu
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Called just after the [ContextMenu] has been hidden. */
fun Menu.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [ContextMenu] being hidden. */
fun Menu.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [ContextMenu] being shown, even if the menu has no items to show. */
fun Menu.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ContextMenu] is shown. */
fun Menu.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> GlobalScope.launch(context) { action(event) } }