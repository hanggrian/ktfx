package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.initToolkit
import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxDialogTest {
    private lateinit var dialog: JFXDialog

    @BeforeTest
    fun start() {
        initToolkit()
        dialog = JFXDialog()
    }

    @Test
    fun onDialogClosed() {
        dialog.onDialogClosed(Dispatchers.Unconfined) {
            assertEquals(JFXDialogEvent.CLOSED, it.eventType)
        }
        dialog.onDialogClosed.handle(JFXDialogEvent(JFXDialogEvent.CLOSED))
    }

    @Test
    fun onDialogOpened() {
        dialog.onDialogOpened(Dispatchers.Unconfined) {
            assertEquals(JFXDialogEvent.OPENED, it.eventType)
        }
        dialog.onDialogOpened.handle(JFXDialogEvent(JFXDialogEvent.OPENED))
    }
}
