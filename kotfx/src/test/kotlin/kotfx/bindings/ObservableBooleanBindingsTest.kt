package kotfx.bindings

import javafx.scene.control.Label
import kotfx.and
import kotfx.eq
import kotfx.neq
import kotfx.or

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