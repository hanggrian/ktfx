package ktfx.controlsfx.listeners

import javafx.event.Event
import ktfx.controlsfx.test.BaseNotificationPaneTest
import org.controlsfx.control.NotificationPane

class NotificationPaneTest : BaseNotificationPaneTest() {

    override fun NotificationPane.callOnShowing(action: (Event) -> Unit) = onShowing(action)
    override fun NotificationPane.callOnShown(action: (Event) -> Unit) = onShown(action)
    override fun NotificationPane.callOnHiding(action: (Event) -> Unit) = onHiding(action)
    override fun NotificationPane.callOnHidden(action: (Event) -> Unit) = onHidden(action)
}
