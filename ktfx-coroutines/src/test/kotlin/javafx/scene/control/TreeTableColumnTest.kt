package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTablePosition
import javafx.scene.control.TreeTableView
import javafx.stage.Stage
import javafx.util.Duration
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TreeTableColumnTest : ApplicationTest() {
    private lateinit var table: TreeTableView<Duration>
    private lateinit var column: TreeTableColumn<Duration, Long>
    private lateinit var position: TreeTablePosition<Duration, Long>

    override fun start(stage: Stage) {
        stage.testScene<TreeTableColumn<*, *>>()
        table = TreeTableView()
        table.columns += TreeTableColumn<Duration, Long>().also { column = it }
        position = TreeTablePosition(table, 0, column)
    }

    @Test
    fun onEditStart() {
        interact {
            column.onEditStart {
                assertEquals(table, it.source)
                assertEquals(position, it.treeTablePosition)
                assertEquals(TreeTableColumn.editStartEvent<Duration, Long>(), it.eventType)
                assertEquals(0, it.newValue)
            }
            column.onEditStart.handle(
                TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editStartEvent(), 0),
            )
        }
    }

    @Test
    fun onEditCommit() {
        interact {
            column.onEditCommit {
                assertEquals(table, it.source)
                assertEquals(position, it.treeTablePosition)
                assertEquals(TreeTableColumn.editCommitEvent<Duration, Long>(), it.eventType)
                assertEquals(0, it.newValue)
            }
            column.onEditCommit.handle(
                TreeTableColumn.CellEditEvent(
                    table,
                    position,
                    TreeTableColumn.editCommitEvent(),
                    0,
                ),
            )
        }
    }

    @Test
    fun onEditCancel() {
        interact {
            column.onEditCancel {
                assertEquals(table, it.source)
                assertEquals(position, it.treeTablePosition)
                assertEquals(TreeTableColumn.editCancelEvent<Duration, Long>(), it.eventType)
                assertEquals(0, it.newValue)
            }
            column.onEditCancel.handle(
                TreeTableColumn.CellEditEvent(
                    table,
                    position,
                    TreeTableColumn.editCancelEvent(),
                    0,
                ),
            )
        }
    }
}
