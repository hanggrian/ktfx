package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.NotificationPane

class NotificationPaneTest : LayoutTest<NodeManager, NotificationPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = notificationPane { }
    override fun NodeManager.child2() = notificationPane()
    override fun NodeManager.child3() = notificationPane { }
}