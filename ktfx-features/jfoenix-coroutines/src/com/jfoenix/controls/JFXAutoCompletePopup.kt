@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

fun <T> JFXAutoCompletePopup<T>.selectionHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXAutoCompleteEvent<T>) -> Unit
): Unit = setSelectionHandler { event -> GlobalScope.launch(context) { action(event) } }
