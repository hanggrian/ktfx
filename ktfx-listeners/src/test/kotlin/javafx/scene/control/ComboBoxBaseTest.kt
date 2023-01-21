package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseComboBoxBaseTest
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase

class ComboBoxBaseTest : BaseComboBoxBaseTest() {
    override fun <E> ComboBoxBase<E>.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
    override fun <E> ComboBoxBase<E>.callOnShowing(action: (Event) -> Unit) = onShowing(action)
    override fun <E> ComboBoxBase<E>.callOnShown(action: (Event) -> Unit) = onShown(action)
    override fun <E> ComboBoxBase<E>.callOnHiding(action: (Event) -> Unit) = onHiding(action)
    override fun <E> ComboBoxBase<E>.callOnHidden(action: (Event) -> Unit) = onHidden(action)
}
