package ktfx.controlsfx.coroutines

import javafx.event.Event
import kotlinx.coroutines.Dispatchers
import ktfx.controlsfx.test.BaseNotificationPaneTest
import org.controlsfx.control.NotificationPane

class NotificationPaneTest : BaseNotificationPaneTest() {
    override fun NotificationPane.callOnShowing(action: (Event) -> Unit): Unit =
        onShowing(Dispatchers.Unconfined) { action(it) }

    override fun NotificationPane.callOnShown(action: (Event) -> Unit): Unit =
        onShown(Dispatchers.Unconfined) { action(it) }

    override fun NotificationPane.callOnHiding(action: (Event) -> Unit): Unit =
        onHiding(Dispatchers.Unconfined) { action(it) }

    override fun NotificationPane.callOnHidden(action: (Event) -> Unit): Unit =
        onHidden(Dispatchers.Unconfined) { action(it) }
}
