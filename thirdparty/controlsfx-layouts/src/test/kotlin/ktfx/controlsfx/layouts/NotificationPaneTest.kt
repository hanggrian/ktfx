package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.NotificationPane

class NotificationPaneTest : LayoutsTest<KtfxPane, NotificationPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): NotificationPane = notificationPane { }
    override fun KtfxPane.child2(): NotificationPane = notificationPane()
    override fun KtfxPane.child3(): NotificationPane = notificationPane { }
}
