package kotfx.layouts.nodes

import javafx.scene.control.Label

@PublishedApi
internal class FXLabelBuilder(text: String?) : LabelBuilder {

    override val t: Label = Label(text)
}

interface LabelBuilder : LabeledBuilder<Label> {

}