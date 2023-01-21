@file:JvmMultifileClass
@file:JvmName("ControlsfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.controlsfx.listeners

import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import org.controlsfx.control.BreadCrumbBar

/**
 * @see BreadCrumbBar.setOnCrumbAction
 */
public inline fun <T> BreadCrumbBar<T>.onCrumbAction(noinline
        action: (BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit): Unit = setOnCrumbAction(action)
