package ktfx.coroutines

import javafx.scene.control.TableColumn
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseTableColumnTest

class TableColumnTest : BaseTableColumnTest() {

    override fun <S, T> TableColumn<S, T>.callOnEditStart(action: (TableColumn.CellEditEvent<S, T>) -> Unit) =
        onEditStart(Dispatchers.Unconfined) { action(it) }

    override fun <S, T> TableColumn<S, T>.callOnEditCommit(action: (TableColumn.CellEditEvent<S, T>) -> Unit) =
        onEditCommit(Dispatchers.Unconfined) { action(it) }

    override fun <S, T> TableColumn<S, T>.callOnEditCancel(action: (TableColumn.CellEditEvent<S, T>) -> Unit) =
        onEditCancel(Dispatchers.Unconfined) { action(it) }
}