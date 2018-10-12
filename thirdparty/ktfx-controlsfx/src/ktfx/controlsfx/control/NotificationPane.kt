@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.NotificationPane

class _NotificationPane(content: Node?) : NotificationPane(content), LayoutManager<Node> {

    override fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [NotificationPane]. */
fun notificationPane(
    content: Node? = null,
    init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = _NotificationPane(content).also { init?.invoke(it) }

/** Creates a [NotificationPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.notificationPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = ktfx.controlsfx.notificationPane(content, init)()