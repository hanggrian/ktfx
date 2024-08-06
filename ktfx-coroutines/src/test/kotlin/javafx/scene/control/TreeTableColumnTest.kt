package ktfx.coroutines

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTablePosition
import javafx.scene.control.TreeTableView
import javafx.util.Duration
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TreeTableColumnTest {
    private lateinit var table: TreeTableView<Duration>
    private lateinit var column: TreeTableColumn<Duration, Long>
    private lateinit var position: TreeTablePosition<Duration, Long>

    @BeforeTest
    fun start() {
        initToolkit()
        table = TreeTableView()
        table.columns += TreeTableColumn<Duration, Long>().also { column = it }
        position = TreeTablePosition(table, 0, column)
    }

    @Test
    fun onEditStart() {
        column.onEditStart(Dispatchers.Unconfined) {
            assertEquals(table, it.source)
            assertEquals(position, it.treeTablePosition)
            assertEquals(TreeTableColumn.editStartEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditStart.handle(
            TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editStartEvent(), 0),
        )
    }

    @Test
    fun onEditCommit() {
        column.onEditCommit(Dispatchers.Unconfined) {
            assertEquals(table, it.source)
            assertEquals(position, it.treeTablePosition)
            assertEquals(TreeTableColumn.editCommitEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditCommit.handle(
            TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editCommitEvent(), 0),
        )
    }

    @Test
    fun onEditCancel() {
        column.onEditCancel(Dispatchers.Unconfined) {
            assertEquals(table, it.source)
            assertEquals(position, it.treeTablePosition)
            assertEquals(TreeTableColumn.editCancelEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditCancel.handle(
            TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editCancelEvent(), 0),
        )
    }
}
