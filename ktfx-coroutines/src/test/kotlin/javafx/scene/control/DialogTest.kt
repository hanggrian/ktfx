package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DialogTest : ApplicationTest() {
    private lateinit var dialog: Dialog<String>

    override fun start(stage: Stage) {
        stage.testScene<Dialog<*>>()
        dialog = Dialog()
    }

    @Test
    fun onCloseRequest() {
        interact {
            dialog.onCloseRequest {
                assertEquals(dialog, it.source)
                assertEquals(DialogEvent.DIALOG_CLOSE_REQUEST, it.eventType)
            }
            dialog.onCloseRequest.handle(DialogEvent(dialog, DialogEvent.DIALOG_CLOSE_REQUEST))
        }
    }

    @Test
    fun onShowing() {
        interact {
            dialog.onShowing {
                assertEquals(dialog, it.source)
                assertEquals(DialogEvent.DIALOG_SHOWING, it.eventType)
            }
            dialog.onShowing.handle(DialogEvent(dialog, DialogEvent.DIALOG_SHOWING))
        }
    }

    @Test
    fun onShown() {
        interact {
            dialog.onShown {
                assertEquals(dialog, it.source)
                assertEquals(DialogEvent.DIALOG_SHOWN, it.eventType)
            }
            dialog.onShown.handle(DialogEvent(dialog, DialogEvent.DIALOG_SHOWN))
        }
    }

    @Test
    fun onHiding() {
        interact {
            dialog.onHiding {
                assertEquals(dialog, it.source)
                assertEquals(DialogEvent.DIALOG_HIDING, it.eventType)
            }
            dialog.onHiding.handle(DialogEvent(dialog, DialogEvent.DIALOG_HIDING))
        }
    }

    @Test
    fun onHidden() {
        interact {
            dialog.onHidden {
                assertEquals(dialog, it.source)
                assertEquals(DialogEvent.DIALOG_HIDDEN, it.eventType)
            }
            dialog.onHidden.handle(DialogEvent(dialog, DialogEvent.DIALOG_HIDDEN))
        }
    }
}
