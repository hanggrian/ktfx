package ktfx.dialogs

import com.google.common.truth.Truth
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import ktfx.test.assertInstance
import kotlin.test.Ignore
import kotlin.test.assertEquals

@Ignore("Error when executed from terminal, test manually instead")
class AlertTest : ShowDialogTest() {
    private val alertsWithTitle = mutableListOf<Alert>()
    private val alerts = mutableListOf<Alert>()
    private val alertResults = mutableSetOf<ButtonType>()

    override fun show() {
        alertResults += alert("Alert", ImageView("file:icon.png"), "Sound the alarm!", ButtonType.OK) {
            alertsWithTitle += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += alert("Sound the alarm!", ButtonType.OK) {
            alerts += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += infoAlert("Alert", ImageView("file:icon.png"), "Sound the alarm!") {
            alertsWithTitle += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += infoAlert("Sound the alarm!") {
            alerts += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += warningAlert("Alert", ImageView("file:icon.png"), "Sound the alarm!") {
            alertsWithTitle += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += warningAlert("Sound the alarm!") {
            alerts += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += confirmAlert("Alert", ImageView("file:icon.png"), "Sound the alarm!") {
            alertsWithTitle += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += confirmAlert("Sound the alarm!") {
            alerts += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += errorAlert("Alert", ImageView("file:icon.png"), "Sound the alarm!") {
            alertsWithTitle += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        alertResults += errorAlert("Sound the alarm!") {
            alerts += this
            setOnShown { push(KeyCode.ENTER) }
        }.get()
    }

    override fun test() {
        alertsWithTitle.forEach {
            assertEquals("Alert", it.headerText)
            assertInstance<ImageView>(it.graphic)
            assertEquals("Sound the alarm!", it.contentText)
        }
        alerts.forEach {
            assertEquals("Sound the alarm!", it.contentText)
        }
        Truth.assertThat(alertResults).containsExactly(ButtonType.OK)
    }
}