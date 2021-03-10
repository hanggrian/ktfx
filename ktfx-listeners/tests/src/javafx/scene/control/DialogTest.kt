package ktfx.listeners

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import io.github.hendraanggrian.ktfx.test.BaseDialogTest
import kotlin.test.Ignore

@Ignore
class DialogTest : BaseDialogTest() {

    override fun <E> Dialog<E>.callOnCloseRequest(action: (DialogEvent) -> Unit) = onCloseRequest(action)
    override fun <E> Dialog<E>.callOnShowing(action: (DialogEvent) -> Unit) = onShowing(action)
    override fun <E> Dialog<E>.callOnShown(action: (DialogEvent) -> Unit) = onShown(action)
    override fun <E> Dialog<E>.callOnHiding(action: (DialogEvent) -> Unit) = onHiding(action)
    override fun <E> Dialog<E>.callOnHidden(action: (DialogEvent) -> Unit) = onHidden(action)
}