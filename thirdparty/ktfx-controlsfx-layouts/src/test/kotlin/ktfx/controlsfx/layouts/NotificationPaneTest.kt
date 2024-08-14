package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.NotificationPane

class NotificationPaneTest : LayoutsStyledTest<KtfxPane, NotificationPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = notificationPane {}

    override fun KtfxPane.child2() = notificationPane()

    override fun child3() = styledNotificationPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledNotificationPane(styleClass = arrayOf("style"))
}
