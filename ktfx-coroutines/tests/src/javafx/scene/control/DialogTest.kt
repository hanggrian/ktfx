package ktfx.coroutines

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlinx.coroutines.Dispatchers
import com.hendraanggrian.ktfx.test.BaseDialogTest
import kotlin.test.Ignore

@Ignore
class DialogTest : BaseDialogTest() {

    override fun <E> Dialog<E>.callOnCloseRequest(action: (DialogEvent) -> Unit) =
        onCloseRequest(Dispatchers.Unconfined) { action(it) }

    override fun <E> Dialog<E>.callOnShowing(action: (DialogEvent) -> Unit) =
        onShowing(Dispatchers.Unconfined) { action(it) }

    override fun <E> Dialog<E>.callOnShown(action: (DialogEvent) -> Unit) =
        onShown(Dispatchers.Unconfined) { action(it) }

    override fun <E> Dialog<E>.callOnHiding(action: (DialogEvent) -> Unit) =
        onHiding(Dispatchers.Unconfined) { action(it) }

    override fun <E> Dialog<E>.callOnHidden(action: (DialogEvent) -> Unit) =
        onHidden(Dispatchers.Unconfined) { action(it) }
}