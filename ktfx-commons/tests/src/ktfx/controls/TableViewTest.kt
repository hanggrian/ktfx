package ktfx.controls

import javafx.scene.control.TableView
import ktfx.testing.ToolkitTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableViewTest : ToolkitTest {

    @Test fun columns() {
        val table = TableView<Nothing>()
        table.columns {
            "Full name"<String> {
                columns {
                    column<String>("First name")
                    column<String>("Last name")
                }
            }
            column<Int>("Age")
        }
        assertEquals(table.columns[0].text, "Full name")
        assertEquals(table.columns[0].columns[0].text, "First name")
        assertEquals(table.columns[0].columns[1].text, "Last name")
        assertEquals(table.columns[1].text, "Age")
    }
}