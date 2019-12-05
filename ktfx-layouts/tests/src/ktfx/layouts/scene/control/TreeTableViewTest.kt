package ktfx.layouts.scene.control

import javafx.scene.control.TreeTableView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.treeTableView
import kotlin.test.assertNull

class TreeTableViewTest : LayoutTest<NodeManager, TreeTableView<String>>() {

    override fun createManager() = KtfxPane()
    override fun create() = treeTableView<String> { }
    override fun NodeManager.add() = treeTableView<String>()
    override fun NodeManager.addWithBuilder() = treeTableView<String> { }

    override fun TreeTableView<String>.testDefaultValues() {
        assertNull(root)
    }
}