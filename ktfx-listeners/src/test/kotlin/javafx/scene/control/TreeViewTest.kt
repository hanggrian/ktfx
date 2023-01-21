package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseTreeViewTest
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView

class TreeViewTest : BaseTreeViewTest() {
    override fun <E> TreeView<E>.callOnEditStart(action: (TreeView.EditEvent<E>) -> Unit) =
        onEditStart(action)

    override fun <E> TreeView<E>.callOnEditCommit(action: (TreeView.EditEvent<E>) -> Unit) =
        onEditCommit(action)

    override fun <E> TreeView<E>.callOnEditCancel(action: (TreeView.EditEvent<E>) -> Unit) =
        onEditCancel(action)

    override fun <E> TreeView<E>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) =
        onScrollTo(action)
}
