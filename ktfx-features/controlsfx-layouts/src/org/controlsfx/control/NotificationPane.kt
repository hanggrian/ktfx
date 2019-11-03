@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.NotificationPane

open class KtfxNotificationPane : NotificationPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [NotificationPane] with initialization block. */
inline fun notificationPane(
    init: (@LayoutDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane = KtfxNotificationPane().apply(init)

/** Add a [NotificationPane] to this manager. */
fun NodeManager.notificationPane(): NotificationPane =
    addNode(KtfxNotificationPane())

/** Add a [NotificationPane] with initialization block to this manager. */
inline fun NodeManager.notificationPane(
    init: (@LayoutDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane = addNode(KtfxNotificationPane(), init)
