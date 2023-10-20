@file:Suppress("ktlint:rulebook:rename-uncommon-generics")

package ktfx.coroutines

import com.hendraanggrian.ktfx.test.TreeTableViewTest
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlinx.coroutines.Dispatchers

class CoroutinesTreeTableViewTest : TreeTableViewTest() {
    override fun <S> TreeTableView<S>.callOnSort(action: (SortEvent<TreeTableView<S>>) -> Unit) =
        onSort(Dispatchers.Unconfined) { action(it) }

    override fun <S> TreeTableView<S>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) =
        onScrollTo(Dispatchers.Unconfined) { action(it) }

    override fun <S> TreeTableView<S>.callOnScrollToColumn(
        action: (ScrollToEvent<TreeTableColumn<S, *>>) -> Unit,
    ) = onScrollToColumn(Dispatchers.Unconfined) { action(it) }
}
