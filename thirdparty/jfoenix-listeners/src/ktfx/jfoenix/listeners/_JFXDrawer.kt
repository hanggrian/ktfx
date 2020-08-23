@file:JvmMultifileClass
@file:JvmName("JFoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXDrawer.setOnDrawerClosed
 */
inline fun JFXDrawer.onDrawerClosed(noinline action: (JFXDrawerEvent) -> Unit) {
    return setOnDrawerClosed(action)
}

/**
 * @see JFXDrawer.setOnDrawerClosing
 */
inline fun JFXDrawer.onDrawerClosing(noinline action: (JFXDrawerEvent) -> Unit) {
    return setOnDrawerClosing(action)
}

/**
 * @see JFXDrawer.setOnDrawerOpened
 */
inline fun JFXDrawer.onDrawerOpened(noinline action: (JFXDrawerEvent) -> Unit) {
    return setOnDrawerOpened(action)
}

/**
 * @see JFXDrawer.setOnDrawerOpening
 */
inline fun JFXDrawer.onDrawerOpening(noinline action: (JFXDrawerEvent) -> Unit) {
    return setOnDrawerOpening(action)
}
