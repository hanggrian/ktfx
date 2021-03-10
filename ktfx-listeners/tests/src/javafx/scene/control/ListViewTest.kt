package ktfx.listeners

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import io.github.hendraanggrian.ktfx.test.BaseListViewTest

class ListViewTest : BaseListViewTest() {

    override fun <E> ListView<E>.callOnEditStart(action: (ListView.EditEvent<E>) -> Unit) = onEditStart(action)
    override fun <E> ListView<E>.callOnEditCommit(action: (ListView.EditEvent<E>) -> Unit) = onEditCommit(action)
    override fun <E> ListView<E>.callOnEditCancel(action: (ListView.EditEvent<E>) -> Unit) = onEditCancel(action)
    override fun <E> ListView<E>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) = onScrollTo(action)
}