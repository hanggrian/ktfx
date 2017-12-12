package kotfx.layouts.controls

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyBooleanProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.ButtonBase

interface ButtonBaseBuilder<out T : ButtonBase> : LabeledBuilder<T> {

    val armedProperty: ReadOnlyBooleanProperty get() = t.armedProperty()
    val isArmed: Boolean get() = t.isArmed

    val onActionProperty: ObjectProperty<EventHandler<ActionEvent>> get() = t.onActionProperty()
    val onAction: EventHandler<ActionEvent> get() = t.onAction
    fun onAction(action: (ActionEvent) -> Unit) = onActionProperty.set(EventHandler(action))

    fun arm() = t.arm()
    fun disarm() = t.disarm()
    fun fire() = t.fire()
}