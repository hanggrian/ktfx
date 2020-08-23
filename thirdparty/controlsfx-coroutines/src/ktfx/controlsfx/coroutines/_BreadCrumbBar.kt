@file:JvmMultifileClass
@file:JvmName("ControlsFxCoroutinesKt")

package ktfx.controlsfx.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.BreadCrumbBar
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see BreadCrumbBar.setOnCrumbAction
 */
fun <T> BreadCrumbBar<T>.onCrumbAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
) {
    return setOnCrumbAction { event -> GlobalScope.launch(context) { action(event) } }
}
