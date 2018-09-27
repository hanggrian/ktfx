@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

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