package ktfx.layouts.scene.control

import ktfx.layouts.NodeManager
import ktfx.layouts.Person
import ktfx.layouts._Pane
import ktfx.layouts.columns
import ktfx.layouts.tableView
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class TableColumnsTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            val tableView = tableView<Person> {
                columns {
                    "Name"<String>()
                    "Age"<Int>()
                }
            }
            assertEquals(tableView.columns[0].text, "Name")
            assertEquals(tableView.columns[1].text, "Age")
        }
    }
}