@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the error event handler. */
fun MediaView.onError(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
) = setOnError { event -> launch(context) { action(event) } }