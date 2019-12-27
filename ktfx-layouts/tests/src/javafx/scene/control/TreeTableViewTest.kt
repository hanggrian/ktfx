package ktfx.layouts

import javafx.scene.control.TreeTableView
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class TreeTableViewTest : LayoutsTest<NodeManager, TreeTableView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = treeTableView<String> { }
    override fun NodeManager.child2() = treeTableView<String>()
    override fun NodeManager.child3() = treeTableView<String> { }

    override fun TreeTableView<String>.testDefaultValues() {
        assertNull(root)
    }
}