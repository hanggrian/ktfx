@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.NotificationPane

/**
 * [NotificationPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxNotificationPane : NotificationPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [NotificationPane] with initialization block. */
inline fun notificationPane(
    init: KtfxNotificationPane.() -> Unit
): NotificationPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxNotificationPane().apply(init)
}

/** Add a [NotificationPane] to this manager. */
fun NodeManager.notificationPane(): NotificationPane =
    addNode(KtfxNotificationPane())

/** Add a [NotificationPane] with initialization block to this manager. */
inline fun NodeManager.notificationPane(
    init: KtfxNotificationPane.() -> Unit
): NotificationPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxNotificationPane(), init)
}
