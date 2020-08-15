@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Dialog.setOnShowing
 */
inline fun Dialog<*>.onShowing(noinline action: (DialogEvent) -> Unit) {
    return setOnShowing(action)
}

/**
 * @see Dialog.setOnShown
 */
inline fun Dialog<*>.onShown(noinline action: (DialogEvent) -> Unit) {
    return setOnShown(action)
}

/**
 * @see Dialog.setOnHiding
 */
inline fun Dialog<*>.onHiding(noinline action: (DialogEvent) -> Unit) {
    return setOnHiding(action)
}

/**
 * @see Dialog.setOnHidden
 */
inline fun Dialog<*>.onHidden(noinline action: (DialogEvent) -> Unit) {
    return setOnHidden(action)
}

/**
 * @see Dialog.setOnCloseRequest
 */
inline fun Dialog<*>.onCloseRequest(noinline action: (DialogEvent) -> Unit) {
    return setOnCloseRequest(action)
}
