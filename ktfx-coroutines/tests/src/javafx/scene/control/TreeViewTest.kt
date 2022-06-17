package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import kotlinx.coroutines.Dispatchers
import com.hendraanggrian.ktfx.test.BaseTreeViewTest

class TreeViewTest : BaseTreeViewTest() {

    override fun <E> TreeView<E>.callOnEditStart(action: (TreeView.EditEvent<E>) -> Unit) =
        onEditStart(Dispatchers.Unconfined) { action(it) }

    override fun <E> TreeView<E>.callOnEditCommit(action: (TreeView.EditEvent<E>) -> Unit) =
        onEditCommit(Dispatchers.Unconfined) { action(it) }

    override fun <E> TreeView<E>.callOnEditCancel(action: (TreeView.EditEvent<E>) -> Unit) =
        onEditCancel(Dispatchers.Unconfined) { action(it) }

    override fun <E> TreeView<E>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) =
        onScrollTo(Dispatchers.Unconfined) { action(it) }
}
