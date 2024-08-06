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

/** Build notifications with Kotlin DSL. */
fun buildNotifications(builderAction: NotificationsBuilder.() -> Unit): Notifications =
    NotificationsBuilder().apply(builderAction).nativeNotifications

/** Supporting class to use [Notifications] with DSL. */
class NotificationsBuilder internal constructor() {
    internal val nativeNotifications: Notifications = Notifications.create()

    /** Specify the text to show in the notification. */
    var text: String
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            nativeNotifications.text(value)
        }

    /** Specify the title to show in the notification. */
    var title: String
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            nativeNotifications.title(value)
        }

    /** Specify the graphic to show in the notification. */
    var graphic: Node
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            nativeNotifications.graphic(value)
        }

    /** Specify the position of the notification on screen, by default it is [Pos.BOTTOM_RIGHT]. */
    var position: Pos
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            nativeNotifications.position(value)
        }

    /**
     * The dialog window owner - which can be [javafx.stage.Screen], [javafx.stage.Window],
     * or [javafx.scene.Node].
     */
    var owner: Any
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            nativeNotifications.owner(value)
        }

    /** Specify the duration that the notification should show, after which it will be hidden. */
    var hideAfter: Duration
        @Deprecated(NO_GETTER, level = ERROR)
        get() = noGetter()
        set(value) {
            nativeNotifications.hideAfter(value)
        }

    /** Specify what to do when the user clicks on the notification. */
    fun onAction(action: (ActionEvent) -> Unit) {
        nativeNotifications.onAction(action)
    }

    /**
     * Specify that the notification should use the built-in dark styling, rather than the default
     * 'modena' notification style.
     */
    fun darkStyle() {
        nativeNotifications.darkStyle()
    }

    /**
     * Specify that the close button in the top-right corner of the notification should not be
     * shown.
     */
    fun hideCloseButton() {
        nativeNotifications.hideCloseButton()
    }

    /** Specify the actions that should be shown in the notification as buttons. */
    fun actions(vararg actions: Action) {
        nativeNotifications.action(*actions)
    }

    /**
     * Collapses all the current notifications into a single notification when the number of
     * notifications exceed the threshold limit. A value of zero will disable the threshold
     * behavior.
     */
    fun threshold(threshold: Int, thresholdNotifications: Notifications) {
        nativeNotifications.threshold(threshold, thresholdNotifications)
    }

    /** Alias of [NotificationsBuilder.threshold] with builder DSL. */
    fun threshold(threshold: Int, thresholdNotificationsBuilder: NotificationsBuilder.() -> Unit) {
        nativeNotifications.threshold(threshold, buildNotifications(thresholdNotificationsBuilder))
    }
}
