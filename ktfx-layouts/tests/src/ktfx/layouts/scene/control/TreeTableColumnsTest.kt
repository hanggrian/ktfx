package ktfx.layouts.scene.control

import ktfx.layouts.NodeManager
import ktfx.layouts.Person
import ktfx.layouts._Pane
import ktfx.layouts.columns
import ktfx.layouts.treeTableView
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class TreeTableColumnsTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        val treeTableView = treeTableView<Person> {
            columns {
                column<String>("Name")
                column<Int>("Age")
            }
        }
        assertEquals(treeTableView.columns[0].text, "Name")
        assertEquals(treeTableView.columns[1].text, "Age")
    }
}