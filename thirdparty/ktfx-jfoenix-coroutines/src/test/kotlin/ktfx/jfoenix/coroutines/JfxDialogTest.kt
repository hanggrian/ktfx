package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.testScene
import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxDialogTest : ApplicationTest() {
    private lateinit var dialog: JFXDialog

    override fun start(stage: Stage) {
        stage.testScene<JFXDialog>()
        dialog = JFXDialog()
    }

    @Test
    fun onDialogClosed() {
        interact {
            dialog.onDialogClosed {
                assertEquals(JFXDialogEvent.CLOSED, it.eventType)
            }
            dialog.onDialogClosed.handle(JFXDialogEvent(JFXDialogEvent.CLOSED))
        }
    }

    @Test
    fun onDialogOpened() {
        interact {
            dialog.onDialogOpened {
                assertEquals(JFXDialogEvent.OPENED, it.eventType)
            }
            dialog.onDialogOpened.handle(JFXDialogEvent(JFXDialogEvent.OPENED))
        }
    }
}
