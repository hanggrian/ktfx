@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Sets the error event handler. */
fun MediaView.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
): Unit = setOnError { event -> GlobalScope.launch(context) { action(event) } }
