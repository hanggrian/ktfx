@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts.controlsfx

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
): NotificationPane = ktfx.layouts.controlsfx.notificationPane(content, init)()

/** Create a styled [NotificationPane]. */
fun styledNotificationPane(
    styleClass: String,
    content: Node? = null,
    init: ((@LayoutDsl NotificationPane).() -> Unit)? = null
): NotificationPane = NotificationPane(content).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [NotificationPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledNotificationPane(
    styleClass: String,
    content: Node? = null,
    noinline init: ((@LayoutDsl NotificationPane).() -> Unit)? = null
): NotificationPane = ktfx.layouts.controlsfx.styledNotificationPane(styleClass, content, init)()