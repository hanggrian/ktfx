package kfx.beans.binding

import javafx.scene.control.Label

class ObservableNumberBindingsTest {

    private val label = Label()

    fun plus() {
        label.widthProperty().add(label.heightProperty())
        label.widthProperty() + label.heightProperty()
    }

    fun minus() {
        label.widthProperty().subtract(label.heightProperty())
        label.widthProperty() - label.heightProperty()
    }

    fun times() {
        label.widthProperty().multiply(label.heightProperty())
        label.widthProperty() * label.heightProperty()
    }

    fun div() {
        label.widthProperty().divide(label.heightProperty())
        label.widthProperty() / label.heightProperty()
    }

    fun eq() {
        label.widthProperty().isEqualTo(label.heightProperty())
        label.widthProperty() eq label.heightProperty()
    }

    fun neq() {
        label.widthProperty().isNotEqualTo(label.heightProperty())
        label.widthProperty() neq label.heightProperty()
    }

    fun greater() {
        label.widthProperty().greaterThan(label.heightProperty())
        label.widthProperty() greater label.heightProperty()
    }

    fun less() {
        label.widthProperty().lessThan(label.heightProperty())
        label.widthProperty() less label.heightProperty()
    }

    fun greaterEq() {
        label.widthProperty().greaterThanOrEqualTo(label.heightProperty())
        label.widthProperty() greaterEq label.heightProperty()
    }

    fun lessEq() {
        label.widthProperty().lessThanOrEqualTo(label.heightProperty())
        label.widthProperty() lessEq label.heightProperty()
    }

    fun min() {
        label.widthProperty().min(label.heightProperty())
        label.widthProperty() min label.heightProperty()
    }

    fun max() {
        label.widthProperty().max(label.heightProperty())
        label.widthProperty() max label.heightProperty()
    }
}