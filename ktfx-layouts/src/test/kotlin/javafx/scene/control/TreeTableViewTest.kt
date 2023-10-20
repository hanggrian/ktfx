package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TreeTableView
import kotlin.test.assertNull

class TreeTableViewTest : LayoutsTest<KtfxPane, TreeTableView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): TreeTableView<String> = treeTableView { }

    override fun KtfxPane.child2(): TreeTableView<String> = treeTableView()

    override fun KtfxPane.child3(): TreeTableView<String> = treeTableView { }

    override fun TreeTableView<String>.testDefaultValues() {
        assertNull(root)
    }
}
