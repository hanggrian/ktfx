@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.thirdparty.jfoenix.listeners

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent

inline fun JFXDrawer.onDrawerClosed(
    noinline action: (JFXDrawerEvent) -> Unit
): Unit = setOnDrawerClosed { event -> action(event) }

inline fun JFXDrawer.onDrawerClosing(
    noinline action: (JFXDrawerEvent) -> Unit
): Unit = setOnDrawerClosing { event -> action(event) }

inline fun JFXDrawer.onDrawerOpened(
    noinline action: (JFXDrawerEvent) -> Unit
): Unit = setOnDrawerOpened { event -> action(event) }

inline fun JFXDrawer.onDrawerOpening(
    noinline action: (JFXDrawerEvent) -> Unit
): Unit = setOnDrawerOpening { event -> action(event) }
