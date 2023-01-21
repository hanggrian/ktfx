package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseListViewTest
import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlinx.coroutines.Dispatchers

class ListViewTest : BaseListViewTest() {
    override fun <E> ListView<E>.callOnEditStart(action: (ListView.EditEvent<E>) -> Unit) =
        onEditStart(Dispatchers.Unconfined) { action(it) }

    override fun <E> ListView<E>.callOnEditCommit(action: (ListView.EditEvent<E>) -> Unit) =
        onEditCommit(Dispatchers.Unconfined) { action(it) }

    override fun <E> ListView<E>.callOnEditCancel(action: (ListView.EditEvent<E>) -> Unit) =
        onEditCancel(Dispatchers.Unconfined) { action(it) }

    override fun <E> ListView<E>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) =
        onScrollTo(Dispatchers.Unconfined) { action(it) }
}
