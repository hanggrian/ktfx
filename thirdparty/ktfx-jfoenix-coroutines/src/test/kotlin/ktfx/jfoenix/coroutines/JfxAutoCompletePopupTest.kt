package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.testScene
import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxAutoCompletePopupTest : ApplicationTest() {
    private lateinit var popup: JFXAutoCompletePopup<String>

    override fun start(stage: Stage) {
        stage.testScene<JFXAutoCompletePopup<*>>()
        popup = JFXAutoCompletePopup()
    }

    @Test
    fun selectionHandler() {
        interact {
            popup.selectionHandler {
                assertEquals(JFXAutoCompleteEvent.SELECTION, it.eventType)
                assertEquals("Hello world", it.`object`)
            }
            popup.selectionHandler
                .handle(JFXAutoCompleteEvent(JFXAutoCompleteEvent.SELECTION, "Hello world"))
        }
    }
}
