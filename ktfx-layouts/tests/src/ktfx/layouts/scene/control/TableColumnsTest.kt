package ktfx.layouts.scene.control

import ktfx.layouts.BaseTest
import ktfx.layouts.Person
import ktfx.layouts.columns
import ktfx.layouts.tableView
import org.junit.Test
import kotlin.test.assertEquals

class TableColumnsTest : BaseTest() {

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