package ktfx.controls

import javafx.scene.control.TreeTableView
import ktfx.testing.ToolkitTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TreeTableViewTest : ToolkitTest {

    @Test fun columns(){
        val treeTable = TreeTableView<Nothing>()
        treeTable.columns {
            column<String>("Name")
            column<Int>("Age")
        }
        assertEquals(treeTable.columns[0].text, "Name")
        assertEquals(treeTable.columns[1].text, "Age")
    }
}