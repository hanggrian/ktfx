package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.initToolkit
import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxAutoCompletePopupTest {
    private lateinit var popup: JFXAutoCompletePopup<String>

    @BeforeTest
    fun start() {
        initToolkit()
        popup = JFXAutoCompletePopup()
    }

    @Test
    fun selectionHandler() {
        popup.selectionHandler(Dispatchers.Unconfined) {
            assertEquals(JFXAutoCompleteEvent.SELECTION, it.eventType)
            assertEquals("Hello world", it.`object`)
        }
        popup.selectionHandler
            .handle(JFXAutoCompleteEvent(JFXAutoCompleteEvent.SELECTION, "Hello world"))
    }
}
