@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.NotificationPane

/** Creates a [NotificationPane]. */
fun notificationPane(
    content: Node? = null,
    init: ((@LayoutDsl NotificationPane).() -> Unit)? = null
): NotificationPane = NotificationPane(content).also {
    init?.invoke(it)
}

/** Creates a [NotificationPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.notificationPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl NotificationPane).() -> Unit)? = null
): NotificationPane = ktfx.controlsfx.notificationPane(content, init)()