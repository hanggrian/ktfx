package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TablePosition
import javafx.scene.control.TableView
import javafx.util.Duration
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableViewTest {
    private lateinit var table: TableView<Duration>
    private lateinit var column: TableColumn<Duration, Long>
    private lateinit var position: TablePosition<Duration, Long>

    @BeforeTest
    fun start() {
        initToolkit()
        table = TableView()
        table.columns += TableColumn<Duration, Long>().also { column = it }
        position = TablePosition(table, 0, column)
    }

    @Test
    fun onSort() {
        table.onSort(Dispatchers.Unconfined) {
            assertEquals(table, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        table.onSort.handle(SortEvent(table, FakeEventTarget))
    }

    @Test
    fun onScrollTo() {
        table.onScrollTo(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(0, it.scrollTarget)
        }
        table.onScrollTo
            .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
    }

    @Test
    fun onScrollToColumn() {
        table.onScrollToColumn(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToColumn<TableColumn<Duration, Long>>(), it.eventType)
            assertEquals(column, it.scrollTarget)
        }
        table.onScrollToColumn
            .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToColumn(), column))
    }
}
