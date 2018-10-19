@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.NotificationPane

open class _NotificationPane : NotificationPane(), NodeManager by NodeManager.INVOKABLE_ONLY {

    override fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [NotificationPane]. */
fun notificationPane(
    init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = _NotificationPane().also { init?.invoke(it) }

/** Creates a [NotificationPane] and add it to this manager. */
inline fun NodeManager.notificationPane(
    noinline init: ((@LayoutDsl _NotificationPane).() -> Unit)? = null
): NotificationPane = ktfx.controlsfx.notificationPane(init)()