package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseChoiceBoxTest
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox

class ChoiceBoxTest : BaseChoiceBoxTest() {
    override fun <E> ChoiceBox<E>.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
    override fun <E> ChoiceBox<E>.callOnShowing(action: (Event) -> Unit) = onShowing(action)
    override fun <E> ChoiceBox<E>.callOnShown(action: (Event) -> Unit) = onShown(action)
    override fun <E> ChoiceBox<E>.callOnHiding(action: (Event) -> Unit) = onHiding(action)
    override fun <E> ChoiceBox<E>.callOnHidden(action: (Event) -> Unit) = onHidden(action)
}
