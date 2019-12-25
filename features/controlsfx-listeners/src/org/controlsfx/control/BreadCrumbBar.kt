@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import org.controlsfx.control.BreadCrumbBar

inline fun <T> BreadCrumbBar<T>.onCrumbAction(
    noinline action: (BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
): Unit = setOnCrumbAction { event -> action(event) }
