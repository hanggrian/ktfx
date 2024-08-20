package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.TableColumn
import javafx.scene.control.TablePosition
import javafx.scene.control.TableView
import javafx.stage.Stage
import javafx.util.Duration
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableColumnTest : ApplicationTest() {
    private lateinit var table: TableView<Duration>
    private lateinit var column: TableColumn<Duration, Long>
    private lateinit var position: TablePosition<Duration, Long>

    override fun start(stage: Stage) {
        stage.testScene<TableColumn<*, *>>()
        table = TableView()
        table.columns += TableColumn<Duration, Long>().also { column = it }
        position = TablePosition(table, 0, column)
    }

    @Test
    fun onEditStart() {
        interact {
            column.onEditStart {
                assertEquals(table, it.source)
                assertEquals(position, it.tablePosition)
                assertEquals(TableColumn.editStartEvent<Duration, Long>(), it.eventType)
                assertEquals(0, it.newValue)
            }
            column.onEditStart.handle(
                TableColumn.CellEditEvent(table, position, TableColumn.editStartEvent(), 0),
            )
        }
    }

    @Test
    fun onEditCommit() {
        interact {
            column.onEditCommit {
                assertEquals(table, it.source)
                assertEquals(position, it.tablePosition)
                assertEquals(TableColumn.editCommitEvent<Duration, Long>(), it.eventType)
                assertEquals(0, it.newValue)
            }
            column.onEditCommit.handle(
                TableColumn.CellEditEvent(table, position, TableColumn.editCommitEvent(), 0),
            )
        }
    }

    @Test
    fun onEditCancel() {
        interact {
            column.onEditCancel {
                assertEquals(table, it.source)
                assertEquals(position, it.tablePosition)
                assertEquals(TableColumn.editCancelEvent<Duration, Long>(), it.eventType)
                assertEquals(0, it.newValue)
            }
            column.onEditCancel.handle(
                TableColumn.CellEditEvent(table, position, TableColumn.editCancelEvent(), 0),
            )
        }
    }
}
