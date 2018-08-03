@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.scene.control.ContextMenu
import javafx.scene.control.Menu
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Called just after the [ContextMenu] has been hidden. */
fun Menu.onHidden(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

/** Called just prior to the [ContextMenu] being hidden. */
fun Menu.onHiding(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

/** Called just prior to the [ContextMenu] being shown, even if the menu has no items to show. */
fun Menu.onShowing(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

/** Called just after the [ContextMenu] is shown. */
fun Menu.onShown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }