package ktfx.layouts.scene.control

import ktfx.layouts.NodeManager
import ktfx.layouts.Person
import ktfx.layouts._Pane
import ktfx.layouts.columns
import ktfx.layouts.treeTableView
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class TreeTableColumnsTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            val treeTableView = treeTableView<Person> {
                columns {
                    "Name"<String>()
                    "Age"<Int>()
                }
            }
            assertEquals(treeTableView.columns[0].text, "Name")
            assertEquals(treeTableView.columns[1].text, "Age")
        }
    }
}