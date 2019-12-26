package ktfx.layouts

import javafx.scene.control.TableView
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty

class TableViewTest : LayoutTest<NodeManager, TableView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = tableView<String> { }
    override fun NodeManager.child2() = tableView<String>()
    override fun NodeManager.child3() = tableView<String> { }

    override fun TableView<String>.testDefaultValues() {
        assertEmpty(items)
    }
}