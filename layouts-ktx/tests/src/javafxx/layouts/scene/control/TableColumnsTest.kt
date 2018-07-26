package javafxx.layouts.scene.control

import javafxx.layouts.Person
import javafxx.layouts.columns
import javafxx.layouts.tableView
import javafxx.test.PlatformTest
import org.junit.Test
import kotlin.test.assertEquals

class TableColumnsTest : PlatformTest() {

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