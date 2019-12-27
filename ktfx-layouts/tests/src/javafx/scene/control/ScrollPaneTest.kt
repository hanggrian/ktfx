package ktfx.layouts

import javafx.scene.control.ScrollPane
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ScrollPaneTest : LayoutsTest<NodeManager, ScrollPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = scrollPane { }
    override fun NodeManager.child2() = scrollPane()
    override fun NodeManager.child3() = scrollPane { }

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }
}