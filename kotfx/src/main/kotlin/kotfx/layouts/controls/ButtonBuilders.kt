package kotfx.layouts.controls

import javafx.beans.property.BooleanProperty
import javafx.scene.control.Button

@PublishedApi
internal class FXButtonBuilder(text: String?) : ButtonBuilder {

    override val t: Button = Button(text)
}

interface ButtonBuilder : ButtonBaseBuilder<Button> {

    val defaultButtonProperty: BooleanProperty get() = t.defaultButtonProperty()
    var isDefaultButton: Boolean
        get() = t.isDefaultButton
        set(value) = t.setDefaultButton(value)

    val cancelButtonProperty: BooleanProperty get() = t.cancelButtonProperty()
    var isCancelButton: Boolean
        get() = t.isCancelButton
        set(value) = t.setCancelButton(value)
}