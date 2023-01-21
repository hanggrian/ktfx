package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseTreeTableViewTest
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

class TreeTableViewTest : BaseTreeTableViewTest() {
    override fun <S> TreeTableView<S>.callOnSort(action: (SortEvent<TreeTableView<S>>) -> Unit) =
        onSort(action)

    override fun <S> TreeTableView<S>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) =
        onScrollTo(action)

    override fun <S> TreeTableView<S>.callOnScrollToColumn(
        action: (ScrollToEvent<TreeTableColumn<S, *>>) -> Unit
    ) = onScrollToColumn(action)
}
