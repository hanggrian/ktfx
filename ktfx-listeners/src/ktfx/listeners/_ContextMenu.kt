@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see ContextMenu.setOnAction
 */
public inline fun ContextMenu.onAction(noinline action: (ActionEvent) -> Unit) {
    return setOnAction(action)
}
