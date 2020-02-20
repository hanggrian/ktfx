@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.NotificationPane

/**
 * [NotificationPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxNotificationPane : NotificationPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}

/** Create a [NotificationPane] with configuration block. */
inline fun notificationPane(
    configuration: (@LayoutDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxNotificationPane().apply(configuration)
}

/** Add a [NotificationPane] to this manager. */
fun NodeManager.notificationPane(): NotificationPane = addChild(KtfxNotificationPane())

/** Add a [NotificationPane] with configuration block to this manager. */
inline fun NodeManager.notificationPane(
    configuration: (@LayoutDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxNotificationPane(), configuration)
}
