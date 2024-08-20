package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.Event
import javafx.scene.control.ContextMenu
import javafx.stage.PopupWindow
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PopupWindowTest : ApplicationTest() {
    private lateinit var window: PopupWindow

    override fun start(stage: Stage) {
        stage.testScene<PopupWindow>()
        window = ContextMenu()
    }

    @Test
    fun onAutoHide() {
        interact {
            window.onAutoHide {
                assertEquals(this@PopupWindowTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            window.onAutoHide.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
