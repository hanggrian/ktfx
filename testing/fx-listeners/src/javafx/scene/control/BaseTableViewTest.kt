package ktfx.test

import com.sun.javafx.application.PlatformImpl
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TablePosition
import javafx.scene.control.TableView
import javafx.util.Duration
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTableViewTest {

    abstract fun <S> TableView<S>.callOnSort(action: (SortEvent<TableView<S>>) -> Unit)
    abstract fun <S> TableView<S>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit)
    abstract fun <S> TableView<S>.callOnScrollToColumn(action: (ScrollToEvent<TableColumn<S, *>>) -> Unit)

    private lateinit var table: TableView<Duration>
    private lateinit var column: TableColumn<Duration, Long>
    private lateinit var position: TablePosition<Duration, Long>

    @BeforeTest fun start() {
        PlatformImpl.startup { }
        table = TableView()
        table.columns += TableColumn<Duration, Long>().also { column = it }
        position = TablePosition(table, 0, column)
    }

    @Test fun onSort() {
        table.callOnSort {
            assertEquals(table, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        table.onSort.handle(SortEvent(table, FakeEventTarget))
    }

    @Test fun onScrollTo() {
        table.callOnScrollTo {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(0, it.scrollTarget)
        }
        table.onScrollTo.handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
    }

    @Test fun onScrollToColumn() {
        table.callOnScrollToColumn {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(column, it.scrollTarget)
        }
        table.onScrollToColumn.handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToColumn(), column))
    }
}