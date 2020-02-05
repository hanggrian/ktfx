package ktfx.controls

import javafx.scene.control.TableView
import javafx.scene.control.TreeTableView
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableConstraintsTest {

    @BeforeTest fun start() = initToolkit()

    @Test fun tableView() {
        val table = TableView<Nothing>()
        table.tableColumns {
            "Full name"<String> {
                tableColumns {
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

    @Test fun treeTableView() {
        val treeTable = TreeTableView<Nothing>()
        treeTable.tableColumns {
            "Full name"<String> {
                tableColumns {
                    column<String>("First name")
                    column<String>("Last name")
                }
            }
            column<Int>("Age")
        }
        assertEquals(treeTable.columns[0].text, "Full name")
        assertEquals(treeTable.columns[0].columns[0].text, "First name")
        assertEquals(treeTable.columns[0].columns[1].text, "Last name")
        assertEquals(treeTable.columns[1].text, "Age")
    }
}
