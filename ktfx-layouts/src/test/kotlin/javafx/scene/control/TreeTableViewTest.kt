package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TreeTableView
import kotlin.test.assertNull

class TreeTableViewTest : LayoutsStyledTest<KtfxPane, TreeTableView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = treeTableView<String> {}

    override fun KtfxPane.child2() = treeTableView<String>()

    override fun child3() = styledTreeTableView<String>()

    override fun KtfxPane.child4() = styledTreeTableView<String>()

    override fun TreeTableView<String>.testDefaultValues() {
        assertNull(root)
    }
}
