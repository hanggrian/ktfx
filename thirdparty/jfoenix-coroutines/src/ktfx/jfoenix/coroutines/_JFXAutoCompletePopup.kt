@file:JvmMultifileClass
@file:JvmName("JFoenixCoroutinesKt")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXAutoCompletePopup.setSelectionHandler
 */
public fun <T> JFXAutoCompletePopup<T>.selectionHandler(
    context: CoroutineContext =
        Dispatchers.JavaFx,
    action: suspend CoroutineScope.(JFXAutoCompleteEvent<T>) -> Unit
) {
    return setSelectionHandler { event -> GlobalScope.launch(context) { action(event) } }
}
