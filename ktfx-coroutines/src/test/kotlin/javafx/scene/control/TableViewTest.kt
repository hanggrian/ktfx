package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseTableViewTest
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlinx.coroutines.Dispatchers

class TableViewTest : BaseTableViewTest() {
    override fun <S> TableView<S>.callOnSort(action: (SortEvent<TableView<S>>) -> Unit) =
        onSort(Dispatchers.Unconfined) { action(it) }

    override fun <S> TableView<S>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) =
        onScrollTo(Dispatchers.Unconfined) { action(it) }

    override fun <S> TableView<S>.callOnScrollToColumn(
        action: (ScrollToEvent<TableColumn<S, *>>) -> Unit
    ) =
        onScrollToColumn(Dispatchers.Unconfined) { action(it) }
}
