@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Sets the error event handler. */
fun MediaView.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
): Unit = setOnError { event -> GlobalScope.launch(context) { action(event) } }
