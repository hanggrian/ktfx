package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TreeView
import kotlin.test.assertNull

class TreeViewTest : LayoutsStyledTest<KtfxPane, TreeView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = treeView<String> {}

    override fun KtfxPane.child2() = treeView<String>()

    override fun child3() = styledTreeView<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledTreeView<String>(styleClass = arrayOf("style"))

    override fun TreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}
