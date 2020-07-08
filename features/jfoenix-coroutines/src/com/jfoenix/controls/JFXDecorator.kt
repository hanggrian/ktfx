@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDecorator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Sets a speficed runnable when clicking on the close button. */
fun JFXDecorator.onCloseButtonAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnCloseButtonAction { GlobalScope.launch(context) { action() } }
