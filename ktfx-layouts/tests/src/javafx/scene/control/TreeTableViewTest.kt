package ktfx.layouts

import javafx.scene.control.TreeTableView
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class TreeTableViewTest : LayoutsTest<KtfxPane, TreeTableView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = treeTableView<String> { }
    override fun KtfxPane.child2() = treeTableView<String>()
    override fun KtfxPane.child3() = treeTableView<String> { }

    override fun TreeTableView<String>.testDefaultValues() {
        assertNull(root)
    }
}