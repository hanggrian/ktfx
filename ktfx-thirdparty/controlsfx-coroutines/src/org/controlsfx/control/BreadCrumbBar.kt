@file:JvmMultifileClass
@file:JvmName("ControlsFxCoroutinesKt")

package ktfx.thirdparty.controlsfx.coroutines

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.BreadCrumbBar

fun <T> BreadCrumbBar<T>.onCrumbAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
): Unit = setOnCrumbAction { event -> GlobalScope.launch(context) { action(event) } }
