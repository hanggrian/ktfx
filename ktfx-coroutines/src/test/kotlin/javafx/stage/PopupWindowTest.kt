package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.Event
import javafx.scene.control.ContextMenu
import javafx.stage.PopupWindow
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PopupWindowTest {
    private lateinit var window: PopupWindow

    @BeforeTest fun start() {
        initToolkit()
        window = ContextMenu()
    }

    @Test
    fun onAutoHide() {
        window.onAutoHide(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        window.onAutoHide.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
