package ktfx.layouts.scene.control

import ktfx.layouts.NodeManager
import ktfx.layouts.Person
import ktfx.layouts._Pane
import ktfx.layouts.columns
import ktfx.layouts.tableView
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class TableColumnsTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        val tableView = tableView<Person> {
            columns {
                column<String>("Name")
                column<Int>("Age")
            }
        }
        assertEquals(tableView.columns[0].text, "Name")
        assertEquals(tableView.columns[1].text, "Age")
    }
}