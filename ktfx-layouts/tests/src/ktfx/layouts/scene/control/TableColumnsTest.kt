package ktfx.layouts.scene.control

import ktfx.layouts.Person
import ktfx.layouts.columns
import ktfx.layouts.tableView
import ktfx.test.ToolkitTest
import org.junit.Test
import kotlin.test.assertEquals

class TableColumnsTest : ToolkitTest {

    @Test fun columns() {
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