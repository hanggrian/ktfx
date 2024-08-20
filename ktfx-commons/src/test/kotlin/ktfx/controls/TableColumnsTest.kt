package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.TableView
import javafx.scene.control.TreeTableView
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TableColumnsTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun tableView() {
        val table = TableView<Nothing>()
        table.columns {
            "Full name"<String> {
                columns {
                    append<String>()
                    append<String>("Value")
                }
            }
            append<Int>("Age")
        }
        assertEquals(table.columns[0].text, "Full name")
        assertNull(table.columns[0].columns[0].text)
        assertEquals(table.columns[0].columns[1].text, "Value")
        assertEquals(table.columns[1].text, "Age")
    }

    @Test
    fun treeTableView() {
        val treeTable = TreeTableView<Nothing>()
        treeTable.columns {
            "Full name"<String> {
                columns {
                    append<String>()
                    append<String>("Value")
                }
            }
            append<Int>("Age")
        }
        assertEquals(treeTable.columns[0].text, "Full name")
        assertNull(treeTable.columns[0].columns[0].text)
        assertEquals(treeTable.columns[0].columns[1].text, "Value")
        assertEquals(treeTable.columns[1].text, "Age")
    }
}
