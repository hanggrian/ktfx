package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import org.controlsfx.control.NotificationPane
import kotlin.test.Test
import kotlin.test.assertIs

class NotificationPaneTest : LayoutsStyledTest<KtfxPane, NotificationPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = notificationPane {}

    override fun KtfxPane.child2() = notificationPane()

    override fun child3() = styledNotificationPane()

    override fun KtfxPane.child4() = styledNotificationPane()

    @Test
    fun add() {
        notificationPane {
            region()
            assertIs<Region>(content)
        }
    }
}
