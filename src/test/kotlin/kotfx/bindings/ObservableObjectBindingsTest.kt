package kotfx.bindings

import javafx.beans.value.ObservableObjectValue
import javafx.scene.control.Label

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class ObservableObjectBindingsTest {

    private val label = Label()

    fun eq() {
        label.alignmentProperty().isEqualTo(label.backgroundProperty())
        label.alignmentProperty() eq label.backgroundProperty()
    }

    fun neq() {
        label.alignmentProperty().isNotEqualTo(label.backgroundProperty())
        label.alignmentProperty() neq label.backgroundProperty()
    }
}