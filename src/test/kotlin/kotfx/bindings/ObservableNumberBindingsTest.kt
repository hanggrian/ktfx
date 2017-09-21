package kotfx.bindings

import javafx.scene.control.Label

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class ObservableNumberBindingsTest {

    private val label = Label()

    fun plus() {
        label.widthProperty().add(label.widthProperty())
        label.widthProperty() + label.widthProperty()
    }

    fun minus() {
        label.widthProperty().subtract(label.widthProperty())
        label.widthProperty() - label.widthProperty()
    }

    fun times() {
        label.widthProperty().multiply(label.widthProperty())
        label.widthProperty() * label.widthProperty()
    }

    fun div() {
        label.widthProperty().divide(label.widthProperty())
        label.widthProperty() / label.widthProperty()
    }

    fun eq() {
        label.widthProperty().isEqualTo(label.widthProperty())
        label.widthProperty() eq label.widthProperty()
    }

    fun neq() {
        label.widthProperty().isNotEqualTo(label.widthProperty())
        label.widthProperty() neq label.widthProperty()
    }

    fun greater() {
        label.widthProperty().greaterThan(label.widthProperty())
        label.widthProperty() greater label.widthProperty()
    }

    fun less() {
        label.widthProperty().lessThan(label.widthProperty())
        label.widthProperty() less label.widthProperty()
    }

    fun greaterEq() {
        label.widthProperty().greaterThanOrEqualTo(label.widthProperty())
        label.widthProperty() greaterEq label.widthProperty()
    }

    fun lessEq() {
        label.widthProperty().lessThanOrEqualTo(label.widthProperty())
        label.widthProperty() lessEq label.widthProperty()
    }

    fun min() {
        label.widthProperty().min(label.widthProperty())
        label.widthProperty() min label.widthProperty()
    }

    fun max() {
        label.widthProperty().max(label.widthProperty())
        label.widthProperty() max label.widthProperty()
    }
}