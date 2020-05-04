package ktfx.listeners

import javafx.scene.control.TableColumn
import com.hendraanggrian.ktfx.test.BaseTableColumnTest

class TableColumnTest : BaseTableColumnTest() {

    override fun <S, T> TableColumn<S, T>.callOnEditStart(action: (TableColumn.CellEditEvent<S, T>) -> Unit) =
        onEditStart(action)

    override fun <S, T> TableColumn<S, T>.callOnEditCommit(action: (TableColumn.CellEditEvent<S, T>) -> Unit) =
        onEditCommit(action)

    override fun <S, T> TableColumn<S, T>.callOnEditCancel(action: (TableColumn.CellEditEvent<S, T>) -> Unit) =
        onEditCancel(action)
}