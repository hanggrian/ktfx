package ktfx.layouts

import javafx.scene.control.TreeView
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class TreeViewTest : LayoutsTest<KtfxPane, TreeView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = treeView<String> { }
    override fun KtfxPane.child2() = treeView<String>()
    override fun KtfxPane.child3() = treeView<String> { }

    override fun TreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}