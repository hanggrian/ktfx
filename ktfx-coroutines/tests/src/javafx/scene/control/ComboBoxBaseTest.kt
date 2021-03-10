package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseComboBoxBaseTest

class ComboBoxBaseTest : BaseComboBoxBaseTest() {

    override fun <E> ComboBoxBase<E>.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }

    override fun <E> ComboBoxBase<E>.callOnShowing(action: (Event) -> Unit) =
        onShowing(Dispatchers.Unconfined) { action(it) }

    override fun <E> ComboBoxBase<E>.callOnShown(action: (Event) -> Unit) =
        onShown(Dispatchers.Unconfined) { action(it) }

    override fun <E> ComboBoxBase<E>.callOnHiding(action: (Event) -> Unit) =
        onHiding(Dispatchers.Unconfined) { action(it) }

    override fun <E> ComboBoxBase<E>.callOnHidden(action: (Event) -> Unit) =
        onHidden(Dispatchers.Unconfined) { action(it) }
}