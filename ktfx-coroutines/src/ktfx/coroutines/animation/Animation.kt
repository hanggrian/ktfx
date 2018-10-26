@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** The action to be executed at the conclusion of this [Animation]. */
fun Animation.onFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnFinished { event -> GlobalScope.launch(context) { action(event) } }