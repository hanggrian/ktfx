package ktfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import javafx.scene.control.ButtonType
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class AlertTest : DialogShowingTest() {
    @Test
    fun alert() {
        interact {
            assertEquals(
                ButtonType.YES,
                alert("Message", ButtonType.YES) {
                    headerTitle = "Alert title"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Alert title", title)
                    assertEquals("Alert title", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Message", contentText)
                }.get(),
            )
        }
    }

    @Test
    fun infoAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                infoAlert("Message") {
                    headerTitle = "Info title"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Info title", headerText)
                    assertEquals("Info title", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Message", contentText)
                }.get(),
            )
        }
    }

    @Test
    fun warningAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                infoAlert("Message") {
                    headerTitle = "Warning title"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Warning title", headerText)
                    assertEquals("Warning title", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Message", contentText)
                }.get(),
            )
        }
    }

    @Test
    fun confirmAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                confirmAlert("Message") {
                    headerTitle = "Confirm title"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Confirm title", headerText)
                    assertEquals("Confirm title", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Message", contentText)
                }.get(),
            )
        }
    }

    @Test
    fun errorAlert() {
        interact {
            assertEquals(
                ButtonType.OK,
                errorAlert("Message") {
                    headerTitle = "Error title"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Error title", headerText)
                    assertEquals("Error title", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Message", contentText)
                }.get(),
            )
        }
    }
}
