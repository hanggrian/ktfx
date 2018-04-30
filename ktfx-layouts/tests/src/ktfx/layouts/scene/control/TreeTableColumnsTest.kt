package ktfx.layouts.scene.control

import ktfx.layouts.BaseTest
import ktfx.layouts.Person
import ktfx.layouts.columns
import ktfx.layouts.treeTableView
import org.junit.Test
import kotlin.test.assertEquals

class TreeTableColumnsTest : BaseTest() {

    @Test fun columns() {
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