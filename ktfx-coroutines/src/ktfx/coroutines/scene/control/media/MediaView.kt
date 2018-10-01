@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the error event handler. */
fun MediaView.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
): Unit = setOnError { event -> GlobalScope.launch(context) { action(event) } }