package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.stage.Stage
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.Dispatchers
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class WindowTest : ApplicationTest() {
    private lateinit var window: Window

    override fun start(stage: Stage) {
        stage.testScene<Window>()
        window = stage
    }

    @Test
    fun onCloseRequest() {
        window.onCloseRequest(Dispatchers.Unconfined) {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_CLOSE_REQUEST, it.eventType)
        }
        window.onCloseRequest.handle(WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST))
    }

    @Test
    fun onShowing() {
        window.onShowing(Dispatchers.Unconfined) {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_SHOWING, it.eventType)
        }
        window.onShowing.handle(WindowEvent(window, WindowEvent.WINDOW_SHOWING))
    }

    @Test
    fun onShown() {
        window.onShown(Dispatchers.Unconfined) {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_SHOWN, it.eventType)
        }
        window.onShown.handle(WindowEvent(window, WindowEvent.WINDOW_SHOWN))
    }

    @Test
    fun onHiding() {
        window.onHiding(Dispatchers.Unconfined) {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_HIDING, it.eventType)
        }
        window.onHiding.handle(WindowEvent(window, WindowEvent.WINDOW_HIDING))
    }

    @Test
    fun onHidden() {
        window.onHidden(Dispatchers.Unconfined) {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_HIDDEN, it.eventType)
        }
        window.onHidden.handle(WindowEvent(window, WindowEvent.WINDOW_HIDDEN))
    }
}
