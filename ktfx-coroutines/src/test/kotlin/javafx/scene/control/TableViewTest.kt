package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TablePosition
import javafx.scene.control.TableView
import javafx.stage.Stage
import javafx.util.Duration
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableViewTest : ApplicationTest() {
    private lateinit var table: TableView<Duration>
    private lateinit var column: TableColumn<Duration, Long>
    private lateinit var position: TablePosition<Duration, Long>

    override fun start(stage: Stage) {
        stage.testScene<TableView<*>>()
        table = TableView()
        table.columns += TableColumn<Duration, Long>().also { column = it }
        position = TablePosition(table, 0, column)
    }

    @Test
    fun onSort() {
        interact {
            table.onSort {
                assertEquals(table, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            table.onSort.handle(SortEvent(table, FakeEventTarget))
        }
    }

    @Test
    fun onScrollTo() {
        interact {
            table.onScrollTo {
                assertEquals(this@TableViewTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
                assertEquals(0, it.scrollTarget)
            }
            table.onScrollTo
                .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
        }
    }

    @Test
    fun onScrollToColumn() {
        interact {
            table.onScrollToColumn {
                assertEquals(this@TableViewTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(
                    ScrollToEvent.scrollToColumn<TableColumn<Duration, Long>>(),
                    it.eventType,
                )
                assertEquals(column, it.scrollTarget)
            }
            table.onScrollToColumn
                .handle(
                    ScrollToEvent(
                        this,
                        FakeEventTarget,
                        ScrollToEvent.scrollToColumn(),
                        column,
                    ),
                )
        }
    }
}
