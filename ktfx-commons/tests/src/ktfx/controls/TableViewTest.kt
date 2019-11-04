package ktfx.controls

import javafx.scene.control.TableView
import ktfx.testing.ToolkitTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableViewTest : ToolkitTest {

    @Test fun columns() {
        val table = TableView<Nothing>()
        table.columns {
            column<String>("Name")
            column<Int>("Age")
        }
        assertEquals(table.columns[0].text, "Name")
        assertEquals(table.columns[1].text, "Age")
    }
}