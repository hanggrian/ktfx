@file:JvmMultifileClass
@file:JvmName("EventsKt")

package kotfx.coroutines

import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun Animation.onFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}