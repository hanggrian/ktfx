package ktfx.layouts.scene.control

import javafx.scene.control.TableView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.tableView
import ktfx.test.assertEmpty

class TableViewTest : LayoutTest<NodeManager, TableView<String>>() {

    override fun createManager() = KtfxPane()
    override fun create() = tableView<String> { }
    override fun NodeManager.add() = tableView<String>()
    override fun NodeManager.addWithBuilder() = tableView<String> { }

    override fun TableView<String>.testDefaultValues() {
        assertEmpty(items)
    }
}