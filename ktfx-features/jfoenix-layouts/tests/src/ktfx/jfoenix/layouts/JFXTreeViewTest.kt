package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class JFXTreeViewTest : LayoutTest<NodeManager, JFXTreeView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTreeView<String> { }
    override fun NodeManager.child2() = jfxTreeView<String>()
    override fun NodeManager.child3() = jfxTreeView<String> { }

    override fun JFXTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}