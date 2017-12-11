package kotfx.dialogs

import javafx.beans.property.ObjectProperty
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog

@PublishedApi
internal class FXAlertBuilder(type: Alert.AlertType) : FXDialogBuilder<ButtonType>(), AlertBuilder {

    override val dialog: Dialog<ButtonType> = Alert(type)

    override val typeProperty: ObjectProperty<Alert.AlertType> get() = alert.alertTypeProperty()

    private val alert: Alert get() = dialog as Alert
}