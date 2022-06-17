package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.NotificationPane

class NotificationPaneTest : LayoutsTest<KtfxPane, NotificationPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = notificationPane { }
    override fun KtfxPane.child2() = notificationPane()
    override fun KtfxPane.child3() = notificationPane { }
}
