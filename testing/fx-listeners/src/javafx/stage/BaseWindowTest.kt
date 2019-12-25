package javafx.stage

import ktfx.test.testScene
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseWindowTest : ApplicationTest() {

    abstract fun Window.callOnCloseRequest(action: (WindowEvent) -> Unit)
    abstract fun Window.callOnShowing(action: (WindowEvent) -> Unit)
    abstract fun Window.callOnShown(action: (WindowEvent) -> Unit)
    abstract fun Window.callOnHiding(action: (WindowEvent) -> Unit)
    abstract fun Window.callOnHidden(action: (WindowEvent) -> Unit)

    private lateinit var window: Window

    override fun start(stage: Stage) {
        stage.testScene<Window>()
        window = stage
    }

    @Test fun onCloseRequest() {
        window.callOnCloseRequest {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_CLOSE_REQUEST, it.eventType)
        }
        window.onCloseRequest.handle(WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST))
    }

    @Test fun onShowing() {
        window.callOnShowing {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_SHOWING, it.eventType)
        }
        window.onShowing.handle(WindowEvent(window, WindowEvent.WINDOW_SHOWING))
    }

    @Test fun onShown() {
        window.callOnShown {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_SHOWN, it.eventType)
        }
        window.onShown.handle(WindowEvent(window, WindowEvent.WINDOW_SHOWN))
    }

    @Test fun onHiding() {
        window.callOnHiding {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_HIDING, it.eventType)
        }
        window.onHiding.handle(WindowEvent(window, WindowEvent.WINDOW_HIDING))
    }

    @Test fun onHidden() {
        window.callOnHidden {
            assertEquals(window, it.source)
            assertEquals(WindowEvent.WINDOW_HIDDEN, it.eventType)
        }
        window.onHidden.handle(WindowEvent(window, WindowEvent.WINDOW_HIDDEN))
    }
}