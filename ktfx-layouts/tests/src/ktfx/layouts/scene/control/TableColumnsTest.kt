package ktfx.layouts.scene.control

import ktfx.application.initToolkit
import ktfx.layouts.Person
import ktfx.layouts.columns
import ktfx.layouts.tableView
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class TableColumnsTest {

    @Before fun init() = initToolkit()

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