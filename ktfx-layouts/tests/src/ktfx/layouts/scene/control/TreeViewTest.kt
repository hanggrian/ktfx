package ktfx.layouts.scene.control

import javafx.scene.control.TreeView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.treeView
import kotlin.test.assertNull

class TreeViewTest : LayoutTest<NodeManager, TreeView<String>>() {

    override fun createManager() = KtfxPane()
    override fun create() = treeView<String> { }
    override fun NodeManager.add() = treeView<String>()
    override fun NodeManager.addWithBuilder() = treeView<String> { }

    override fun TreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}