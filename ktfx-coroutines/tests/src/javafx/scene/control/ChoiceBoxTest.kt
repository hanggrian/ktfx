package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseChoiceBoxTest

class ChoiceBoxTest : BaseChoiceBoxTest() {

    override fun <E> ChoiceBox<E>.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }

    override fun <E> ChoiceBox<E>.callOnShowing(action: (Event) -> Unit) =
        onShowing(Dispatchers.Unconfined) { action(it) }

    override fun <E> ChoiceBox<E>.callOnShown(action: (Event) -> Unit) =
        onShown(Dispatchers.Unconfined) { action(it) }

    override fun <E> ChoiceBox<E>.callOnHiding(action: (Event) -> Unit) =
        onHiding(Dispatchers.Unconfined) { action(it) }

    override fun <E> ChoiceBox<E>.callOnHidden(action: (Event) -> Unit) =
        onHidden(Dispatchers.Unconfined) { action(it) }
}