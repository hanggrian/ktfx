package kotfx.layouts.controls

import javafx.beans.property.ObjectProperty
import javafx.scene.Node
import javafx.scene.control.Label

@PublishedApi
internal class FXLabelBuilder(text: String?) : LabelBuilder {

    override val t: Label = Label(text)
}

interface LabelBuilder : LabeledBuilder<Label> {

    val labelForProperty: ObjectProperty<Node> get() = t.labelForProperty()
    var labelFor: Node
        get() = t.labelFor
        set(value) = t.setLabelFor(value)
}