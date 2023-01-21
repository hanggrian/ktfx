package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TreeView
import kotlin.test.assertNull

class TreeViewTest : LayoutsTest<KtfxPane, TreeView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): TreeView<String> = treeView { }
    override fun KtfxPane.child2(): TreeView<String> = treeView()
    override fun KtfxPane.child3(): TreeView<String> = treeView { }

    override fun TreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}
