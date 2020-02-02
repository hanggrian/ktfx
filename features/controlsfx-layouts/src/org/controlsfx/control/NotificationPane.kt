@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.NotificationPane

/**
 * [NotificationPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxNotificationPane : NotificationPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }

    final override val childCount: Int get() = if (content != null) 1 else 0
}

/** Create a [NotificationPane] with initialization block. */
inline fun notificationPane(
    init: (@LayoutsDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxNotificationPane().apply(init)
}

/** Add a [NotificationPane] to this manager. */
fun NodeManager.notificationPane(): NotificationPane = addChild(KtfxNotificationPane())

/** Add a [NotificationPane] with initialization block to this manager. */
inline fun NodeManager.notificationPane(
    init: (@LayoutsDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxNotificationPane(), init)
}
