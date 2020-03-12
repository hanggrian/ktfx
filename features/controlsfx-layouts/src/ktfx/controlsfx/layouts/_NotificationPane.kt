@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.NotificationPane

/**
 * Add a [NotificationPane] to this manager.
 */
fun NodeManager.notificationPane(): NotificationPane = notificationPane() { }

/**
 * Create a [NotificationPane] with configuration block.
 */
inline fun notificationPane(configuration: (@LayoutDslMarker KtfxNotificationPane).() -> Unit):
        NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxNotificationPane(), configuration = configuration)
}

/**
 * Add a [NotificationPane] with configuration block to this manager.
 */
inline fun NodeManager.notificationPane(
    configuration: (@LayoutDslMarker KtfxNotificationPane).() ->
Unit
): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxNotificationPane(), configuration = configuration))
}

/**
 * Create a styled [NotificationPane].
 */
fun styledNotificationPane(vararg styleClass: String, id: String? = null): NotificationPane =
        styledNotificationPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [NotificationPane] to this manager.
 */
fun NodeManager.styledNotificationPane(vararg styleClass: String, id: String? = null):
        NotificationPane = styledNotificationPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [NotificationPane] with configuration block.
 */
inline fun styledNotificationPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxNotificationPane(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [NotificationPane] with configuration block to this manager.
 */
inline fun NodeManager.styledNotificationPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxNotificationPane).() -> Unit
): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxNotificationPane(), styleClass = *styleClass, id = id,
            configuration = configuration))
}
