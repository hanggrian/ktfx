@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.controls

import javafx.event.ActionEvent
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.util.Duration
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import org.controlsfx.control.Notifications
import org.controlsfx.control.action.Action
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Build notifications with Kotlin DSL. */
public inline fun buildNotifications(
    builderAction: NotificationsBuilder.() -> Unit,
): Notifications {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return NotificationsBuilder().apply(builderAction).notifications
}

/** Supporting class to use [Notifications] with DSL. */
public class NotificationsBuilder {
    public val notifications: Notifications = Notifications.create()

    /** Specify the text to show in the notification. */
    public var text: String
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            notifications.text(value)
        }

    /** Specify the title to show in the notification. */
    public var title: String
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            notifications.title(value)
        }

    /** Specify the graphic to show in the notification. */
    public var graphic: Node
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            notifications.graphic(value)
        }

    /** Specify the position of the notification on screen, by default it is [Pos.BOTTOM_RIGHT]. */
    public var position: Pos
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            notifications.position(value)
        }

    /**
     * The dialog window owner - which can be [javafx.stage.Screen], [javafx.stage.Window],
     * or [javafx.scene.Node].
     */
    public var owner: Any
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            notifications.owner(value)
        }

    /** Specify the duration that the notification should show, after which it will be hidden. */
    public var hideAfter: Duration
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            notifications.hideAfter(value)
        }

    /** Specify what to do when the user clicks on the notification. */
    public fun onAction(action: (ActionEvent) -> Unit) {
        notifications.onAction(action)
    }

    /**
     * Specify that the notification should use the built-in dark styling, rather than the default
     * 'modena' notification style.
     */
    public fun darkStyle() {
        notifications.darkStyle()
    }

    /**
     * Specify that the close button in the top-right corner of the notification should not be
     * shown.
     */
    public fun hideCloseButton() {
        notifications.hideCloseButton()
    }

    /** Specify the actions that should be shown in the notification as buttons. */
    public fun actions(vararg actions: Action) {
        notifications.action(*actions)
    }

    /**
     * Collapses all the current notifications into a single notification when the number of
     * notifications exceed the threshold limit. A value of zero will disable the threshold
     * behavior.
     */
    public fun threshold(threshold: Int, thresholdNotifications: Notifications) {
        notifications.threshold(threshold, thresholdNotifications)
    }

    /** Alias of [NotificationsBuilder.threshold] with builder DSL. */
    public fun threshold(
        threshold: Int,
        thresholdNotificationsBuilder: NotificationsBuilder.() -> Unit,
    ) {
        notifications.threshold(threshold, buildNotifications(thresholdNotificationsBuilder))
    }
}
