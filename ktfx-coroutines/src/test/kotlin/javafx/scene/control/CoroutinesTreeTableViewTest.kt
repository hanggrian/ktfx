package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTablePosition
import javafx.scene.control.TreeTableView
import javafx.util.Duration
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CoroutinesTreeTableViewTest {
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
            assertEquals(
                ScrollToEvent.scrollToColumn<TreeTableColumn<Duration, Long>>(),
                it.eventType,
            )
            assertEquals(column, it.scrollTarget)
        }
        table.onScrollToColumn
            .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToColumn(), column))
    }
}
