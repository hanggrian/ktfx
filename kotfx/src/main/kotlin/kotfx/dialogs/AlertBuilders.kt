package kotfx.dialogs

import javafx.beans.property.ObjectProperty
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog

@PublishedApi
internal class FXAlertDialogBuilder(type: Alert.AlertType) : FXDialogBuilder<ButtonType>(), AlertBuilder {

    override val t: Dialog<ButtonType> = Alert(type)
}

interface AlertBuilder : DialogBuilder<ButtonType> {

    val typeProperty: ObjectProperty<Alert.AlertType> get() = (t as Alert).alertTypeProperty()
    var type: Alert.AlertType
        get() = (t as Alert).alertType
        set(value) = (t as Alert).setAlertType(value)
}