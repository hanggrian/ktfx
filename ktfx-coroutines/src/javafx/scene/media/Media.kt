@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.media.Media
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Set the event handler to be called when an error occurs. */
fun Media.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnError { GlobalScope.launch(context) { action() } }
