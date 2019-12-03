package ktfx.dialogs

import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import ktfx.test.DialogApplicationTest
import ktfx.test.assertInstance
import kotlin.test.Test
import kotlin.test.assertEquals

class AlertTest : DialogApplicationTest() {

    @Test fun alert() {
        interact {
            assertEquals(ButtonType.YES, alert("Alert title", ImageView("file:icon.png"), "Message", ButtonType.YES) {
                closeOnShow()
                assertEquals("Alert title", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Message", contentText)
            }.get())
            assertEquals(ButtonType.FINISH, alert("Message", ButtonType.FINISH) {
                closeOnShow()
                assertEquals("Message", contentText)
            }.get())
        }
    }

    @Test fun infoAlert() {
        interact {
            assertEquals(ButtonType.OK, infoAlert("Info title", ImageView("file:icon.png"), "Message") {
                closeOnShow()
                assertEquals("Info title", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Message", contentText)
            }.get())
            assertEquals(ButtonType.OK, infoAlert("Message") {
                closeOnShow()
                assertEquals("Message", contentText)
            }.get())
        }
    }

    @Test fun warningAlert() {
        interact {
            assertEquals(ButtonType.OK, infoAlert("Warning title", ImageView("file:icon.png"), "Message") {
                closeOnShow()
                assertEquals("Warning title", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Message", contentText)
            }.get())
            assertEquals(ButtonType.OK, infoAlert("Message") {
                closeOnShow()
                assertEquals("Message", contentText)
            }.get())
        }
    }

    @Test fun confirmAlert() {
        interact {
            assertEquals(ButtonType.OK, confirmAlert("Confirm title", ImageView("file:icon.png"), "Message") {
                closeOnShow()
                assertEquals("Confirm title", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Message", contentText)
            }.get())
            assertEquals(ButtonType.OK, confirmAlert("Message") {
                closeOnShow()
                assertEquals("Message", contentText)
            }.get())
        }
    }

    @Test fun errorAlert() {
        interact {
            assertEquals(ButtonType.OK, errorAlert("Error title", ImageView("file:icon.png"), "Message") {
                closeOnShow()
                assertEquals("Error title", headerText)
                assertInstance<ImageView>(graphic)
                assertEquals("Message", contentText)
            }.get())
            assertEquals(ButtonType.OK, errorAlert("Message") {
                closeOnShow()
                assertEquals("Message", contentText)
            }.get())
        }
    }
}