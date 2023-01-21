package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseTreeTableColumnTest
import javafx.scene.control.TreeTableColumn

class TreeTableColumnTest : BaseTreeTableColumnTest() {
    override fun <S, T> TreeTableColumn<S, T>.callOnEditStart(
        action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
    ) = onEditStart(action)

    override fun <S, T> TreeTableColumn<S, T>.callOnEditCommit(
        action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
    ) = onEditCommit(action)

    override fun <S, T> TreeTableColumn<S, T>.callOnEditCancel(
        action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
    ) = onEditCancel(action)
}
