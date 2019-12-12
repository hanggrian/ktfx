package ktfx.layouts.scene.control

import javafx.scene.control.TableView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.tableView
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty

class TableViewTest : BaseLayoutTest<NodeManager, TableView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = tableView<String> { }
    override fun NodeManager.child2() = tableView<String>()
    override fun NodeManager.child3() = tableView<String> { }

    override fun TableView<String>.testDefaultValues() {
        assertEmpty(items)
    }
}