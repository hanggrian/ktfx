package ktfx.layouts.scene.control

import javafx.scene.control.ScrollPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.scrollPane
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class ScrollPaneTest : BaseLayoutTest<NodeManager, ScrollPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = scrollPane { }
    override fun NodeManager.child2() = scrollPane()
    override fun NodeManager.child3() = scrollPane { }

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }
}