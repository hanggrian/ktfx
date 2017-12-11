package kotfx.dialogs

import javafx.beans.property.ObjectProperty
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

interface AlertBuilder : DialogBuilder<ButtonType> {

    val typeProperty: ObjectProperty<Alert.AlertType>
    var type: Alert.AlertType
        get() = typeProperty.get()
        set(value) = typeProperty.set(value)
}