package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseTreeTableColumnTest
import javafx.scene.control.TreeTableColumn
import kotlinx.coroutines.Dispatchers

class TreeTableColumnTest : BaseTreeTableColumnTest() {
    override fun <S, T> TreeTableColumn<S, T>.callOnEditStart(
        action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
    ) =
        onEditStart(Dispatchers.Unconfined) { action(it) }

    override fun <S, T> TreeTableColumn<S, T>.callOnEditCommit(
        action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
    ) =
        onEditCommit(Dispatchers.Unconfined) { action(it) }

    override fun <S, T> TreeTableColumn<S, T>.callOnEditCancel(
        action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
    ) =
        onEditCancel(Dispatchers.Unconfined) { action(it) }
}
