package ktfx.jfoenix.test

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseJFXAutoCompletePopupTest {
    private lateinit var popup: JFXAutoCompletePopup<String>

    abstract fun <E> JFXAutoCompletePopup<E>.callSelectionHandler(action: (JFXAutoCompleteEvent<E>) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        popup = JFXAutoCompletePopup()
    }

    @Test fun selectionHandler() {
        popup.callSelectionHandler {
            assertEquals(JFXAutoCompleteEvent.SELECTION, it.eventType)
            assertEquals("Hello world", it.`object`)
        }
        popup.selectionHandler.handle(JFXAutoCompleteEvent(JFXAutoCompleteEvent.SELECTION, "Hello world"))
    }
}