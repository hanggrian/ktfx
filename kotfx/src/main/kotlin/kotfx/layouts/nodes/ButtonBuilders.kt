package kotfx.layouts.nodes

import javafx.beans.property.ObjectProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button

@PublishedApi
internal class FXButtonBuilder(text: String?) : ButtonBuilder {

    override val t: Button = Button(text)
}

interface ButtonBuilder : LabeledBuilder<Button> {

    val onActionProperty: ObjectProperty<EventHandler<ActionEvent>> get() = t.onActionProperty()
    fun onAction(action: (ActionEvent) -> Unit) = onActionProperty.set(EventHandler(action))
}