@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import org.controlsfx.control.BreadCrumbBar
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see BreadCrumbBar.setOnCrumbAction
 */
public inline fun <T> BreadCrumbBar<T>.onCrumbAction(
    noinline
    action: (BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
) {
    return setOnCrumbAction(action)
}
