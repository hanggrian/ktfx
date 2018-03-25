package ktfx.coroutines

import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The action to be executed at the conclusion of this [Animation]. */
fun Animation.onFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnFinished { event -> launch(context) { action(event) } }