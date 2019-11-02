@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

fun <T> JFXAutoCompletePopup<T>.selectionHandler(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXAutoCompleteEvent<T>) -> Unit
): Unit = setSelectionHandler { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }
