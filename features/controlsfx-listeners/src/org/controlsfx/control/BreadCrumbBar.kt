@file:JvmMultifileClass
@file:JvmName("ControlsfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import org.controlsfx.control.BreadCrumbBar

/** Set a new EventHandler for when a user selects a crumb. */
inline fun <T> BreadCrumbBar<T>.onCrumbAction(
    noinline action: (BreadCrumbBar.BreadCrumbActionEvent<T>) -> Unit
): Unit = setOnCrumbAction { event -> action(event) }
