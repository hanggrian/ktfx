package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class DialogTest : ApplicationTest() {
    private lateinit var dialog: Dialog<String>

    override fun start(stage: Stage) {
        stage.testScene<Dialog<*>>()
        dialog = Dialog()
    }

    @Test
    fun onCloseRequest() {
        dialog.onCloseRequest(Dispatchers.Unconfined) {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_CLOSE_REQUEST, it.eventType)
        }
        dialog.onCloseRequest.handle(DialogEvent(dialog, DialogEvent.DIALOG_CLOSE_REQUEST))
    }

    @Test
    fun onShowing() {
        dialog.onShowing(Dispatchers.Unconfined) {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_SHOWING, it.eventType)
        }
        dialog.onShowing.handle(DialogEvent(dialog, DialogEvent.DIALOG_SHOWING))
    }

    @Test
    fun onShown() {
        dialog.onShown(Dispatchers.Unconfined) {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_SHOWN, it.eventType)
        }
        dialog.onShown.handle(DialogEvent(dialog, DialogEvent.DIALOG_SHOWN))
    }

    @Test
    fun onHiding() {
        dialog.onHiding(Dispatchers.Unconfined) {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_HIDING, it.eventType)
        }
        dialog.onHiding.handle(DialogEvent(dialog, DialogEvent.DIALOG_HIDING))
    }

    @Test
    fun onHidden() {
        dialog.onHidden(Dispatchers.Unconfined) {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_HIDDEN, it.eventType)
        }
        dialog.onHidden.handle(DialogEvent(dialog, DialogEvent.DIALOG_HIDDEN))
    }
}
