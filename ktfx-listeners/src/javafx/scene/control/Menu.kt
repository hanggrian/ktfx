@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.scene.control.ContextMenu
import javafx.scene.control.Menu

/** Called just prior to the [ContextMenu] being shown, even if the menu has no items to show. */
inline fun Menu.onShowing(
    noinline action: (Event) -> Unit
): Unit = setOnShowing(action)

/** Called just after the [ContextMenu] is shown. */
inline fun Menu.onShown(
    noinline action: (Event) -> Unit
): Unit = setOnShown(action)

/** Called just prior to the [ContextMenu] being hidden. */
inline fun Menu.onHiding(
    noinline action: (Event) -> Unit
): Unit = setOnHiding(action)

/** Called just after the [ContextMenu] has been hidden. */
inline fun Menu.onHidden(
    noinline action: (Event) -> Unit
): Unit = setOnHidden(action)
