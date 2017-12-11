package kotfx.layouts.nodes

import javafx.beans.property.StringProperty
import javafx.scene.control.Labeled

interface LabeledBuilder<out T : Labeled> : NodeBuilder<T> {

    val textProperty: StringProperty get() = t.textProperty()
    var text: String
        get() = textProperty.get()
        set(value) = textProperty.set(value)
}