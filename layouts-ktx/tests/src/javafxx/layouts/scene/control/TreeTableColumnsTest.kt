package javafxx.layouts.scene.control

import javafxx.layouts.Person
import javafxx.layouts.columns
import javafxx.layouts.treeTableView
import javafxx.test.PlatformTest
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