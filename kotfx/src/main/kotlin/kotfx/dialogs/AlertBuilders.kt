package kotfx.dialogs

import javafx.beans.property.ObjectProperty
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

@PublishedApi
internal class FXAlertDialogBuilder(type: Alert.AlertType) : AlertBuilder {

    override val instance: Alert = Alert(type)
}

interface AlertBuilder : DialogBuilder<Alert, ButtonType> {

    val typeProperty: ObjectProperty<Alert.AlertType> get() = instance.alertTypeProperty()
    var type: Alert.AlertType
        get() = instance.alertType
        set(value) = instance.setAlertType(value)
}