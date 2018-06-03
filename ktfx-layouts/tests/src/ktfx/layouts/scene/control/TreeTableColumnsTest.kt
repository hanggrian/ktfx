package ktfx.layouts.scene.control

import ktfx.layouts.Person
import ktfx.layouts.columns
import ktfx.layouts.treeTableView
import ktfx.test.PlatformTest
import org.junit.Test
import kotlin.test.assertEquals

class TreeTableColumnsTest : PlatformTest() {

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