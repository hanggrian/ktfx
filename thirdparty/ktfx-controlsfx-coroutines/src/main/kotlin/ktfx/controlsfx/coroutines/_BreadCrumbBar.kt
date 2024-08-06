@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.controlsfx.coroutines

import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.BreadCrumbBar

/**
 * @see BreadCrumbBar.setOnCrumbAction
 */
public fun <T> BreadCrumbBar<T>.onCrumbAction(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit): Unit =
        setOnCrumbAction { event -> GlobalScope.launch(context) { action(event) } }
