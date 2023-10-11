package ktfx.dialogs

import com.hendraanggrian.ktfx.test.DialogShowingTest
import javafx.scene.control.ButtonType
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class AlertsTest : DialogShowingTest() {
    @Test
    fun alert() {
        interact {
            assertEquals(
                ButtonType.YES,
                alert("Alert title", sampleGraphic, "Message", ButtonType.YES) {
                    closeOnShow(this)
                    assertEquals("Alert title", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Message", contentText)
                }.get()
            )
            assertEquals(
                ButtonType.FINISH,
                alert("Message", ButtonType.FINISH) {
                    closeOnShow(this)
                    assertEquals("Message", contentText)
                }.get()
            )
        }
    }

    @Test
    fun infoAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                infoAlert("Info title", sampleGraphic, "Message") {
                    closeOnShow(this)
                    assertEquals("Info title", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Message", contentText)
                }.get()
            )
            assertEquals(
                ButtonType.OK,
                infoAlert("Message") {
                    closeOnShow(this)
                    assertEquals("Message", contentText)
                }.get()
            )
        }
    }

    @Test
    fun warningAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                infoAlert("Warning title", sampleGraphic, "Message") {
                    closeOnShow(this)
                    assertEquals("Warning title", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Message", contentText)
                }.get()
            )
            assertEquals(
                ButtonType.OK,
                infoAlert("Message") {
                    closeOnShow(this)
                    assertEquals("Message", contentText)
                }.get()
            )
        }
    }

    @Test
    fun confirmAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                confirmAlert("Confirm title", sampleGraphic, "Message") {
                    closeOnShow(this)
                    assertEquals("Confirm title", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Message", contentText)
                }.get()
            )
            assertEquals(
                ButtonType.OK,
                confirmAlert("Message") {
                    closeOnShow(this)
                    assertEquals("Message", contentText)
                }.get()
            )
        }
    }

    @Test
    fun errorAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                errorAlert("Error title", sampleGraphic, "Message") {
                    closeOnShow(this)
                    assertEquals("Error title", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Message", contentText)
                }.get()
            )
            assertEquals(
                ButtonType.OK,
                errorAlert("Message") {
                    closeOnShow(this)
                    assertEquals("Message", contentText)
                }.get()
            )
        }
    }
}
