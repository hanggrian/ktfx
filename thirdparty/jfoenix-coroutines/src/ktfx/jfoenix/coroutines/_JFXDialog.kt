@file:JvmMultifileClass
@file:JvmName("JFoenixCoroutinesKt")

package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
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
 * @see JFXDialog.setOnDialogClosed
 */
fun JFXDialog.onDialogClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(JFXDialogEvent) -> Unit
) {
    return setOnDialogClosed { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see JFXDialog.setOnDialogOpened
 */
fun JFXDialog.onDialogOpened(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(JFXDialogEvent) -> Unit
) {
    return setOnDialogOpened { event -> GlobalScope.launch(context) { action(event) } }
}
