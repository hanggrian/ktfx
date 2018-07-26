package javafxx.beans.binding

import javafx.scene.control.Label
import javafxx.beans.value.and
import javafxx.beans.value.eq
import javafxx.beans.value.neq
import javafxx.beans.value.or

class ObservableBooleanBindingsTest {

    private val label = Label()

    fun and() {
        label.disableProperty().and(label.disabledProperty())
        label.disableProperty() and label.disabledProperty()
    }

    fun or() {
        label.disableProperty().or(label.disabledProperty())
        label.disableProperty() or label.disabledProperty()
    }

    fun eq() {
        label.disableProperty().isEqualTo(label.disabledProperty())
        label.disableProperty() eq label.disabledProperty()
    }

    fun neq() {
        label.disableProperty().isNotEqualTo(label.disabledProperty())
        label.disableProperty() neq label.disabledProperty()
    }
}