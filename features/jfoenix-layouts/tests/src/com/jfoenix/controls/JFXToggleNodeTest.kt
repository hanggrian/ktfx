package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleNode
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXToggleNodeTest : LayoutsTest<NodeManager, JFXToggleNode>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxToggleNode { }
    override fun NodeManager.child2() = jfxToggleNode()
    override fun NodeManager.child3() = jfxToggleNode { }

    override fun JFXToggleNode.testDefaultValues() {
        assertNull(graphic)
    }
}