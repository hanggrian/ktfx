@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.NotificationPane

class _NotificationPane(content: Node?) : NotificationPane(content), NodeManager {

    override fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [NotificationPane]. */
fun notificationPane(
    content: Node? = null,
    init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = _NotificationPane(content).also { init?.invoke(it) }

/** Creates a [NotificationPane] and add it to this manager. */
inline fun NodeManager.notificationPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = ktfx.controlsfx.notificationPane(content, init)()