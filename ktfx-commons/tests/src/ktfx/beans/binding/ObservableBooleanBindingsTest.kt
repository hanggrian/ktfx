package ktfx.beans.binding

import javafx.scene.control.Label
import ktfx.beans.value.and
import ktfx.beans.value.eq
import ktfx.beans.value.neq
import ktfx.beans.value.or

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