@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.NotificationPane

/**
 * Add a [NotificationPane] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.notificationPane(): NotificationPane = notificationPane() { }

/**
 * Create a [NotificationPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun notificationPane(configuration: (@KtfxLayoutDslMarker
        KtfxNotificationPane).() -> Unit): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxNotificationPane()
    child.configuration()
    return child
}

/**
 * Add a [NotificationPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.notificationPane(configuration: (@KtfxLayoutDslMarker
        KtfxNotificationPane).() -> Unit): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxNotificationPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [NotificationPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledNotificationPane(vararg styleClass: String, id: String? = null): NotificationPane =
        styledNotificationPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [NotificationPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledNotificationPane(vararg styleClass: String, id: String? = null):
        NotificationPane = styledNotificationPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [NotificationPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledNotificationPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxNotificationPane).() -> Unit,
): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxNotificationPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [NotificationPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledNotificationPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxNotificationPane).() -> Unit,
): NotificationPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxNotificationPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
