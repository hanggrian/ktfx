package javafx.scene.web

import javafx.geometry.Rectangle2D
import javafx.stage.Stage
import com.hendraanggrian.ktfx.test.testScene
import org.testfx.framework.junit.ApplicationTest
import java.io.IOException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

abstract class BaseWebEngineTest : ApplicationTest() {
    private lateinit var engine: WebEngine

    abstract fun WebEngine.callOnAlert(action: (WebEvent<String>) -> Unit)
    abstract fun WebEngine.callOnStatusChanged(action: (WebEvent<String>) -> Unit)
    abstract fun WebEngine.callOnResized(action: (WebEvent<Rectangle2D>) -> Unit)
    abstract fun WebEngine.callOnVisibilityChanged(action: (WebEvent<Boolean>) -> Unit)
    abstract fun WebEngine.callOnError(action: (WebErrorEvent) -> Unit)

    override fun start(stage: Stage) {
        stage.testScene<WebEngine>()
        engine = WebEngine()
    }

    @Test
    fun onAlert() {
        engine.callOnAlert {
            assertEquals(this, it.source)
            assertEquals(WebEvent.ALERT, it.eventType)
            assertEquals("Hello world", it.data)
        }
        engine.onAlert.handle(WebEvent(this, WebEvent.ALERT, "Hello world"))
    }

    @Test
    fun onStatusChanged() {
        engine.callOnStatusChanged {
            assertEquals(this, it.source)
            assertEquals(WebEvent.STATUS_CHANGED, it.eventType)
            assertEquals("Hello world", it.data)
        }
        engine.onStatusChanged.handle(WebEvent(this, WebEvent.STATUS_CHANGED, "Hello world"))
    }

    @Test
    fun onResized() {
        engine.callOnResized {
            assertEquals(this, it.source)
            assertEquals(WebEvent.RESIZED, it.eventType)
            assertEquals(Rectangle2D.EMPTY, it.data)
        }
        engine.onResized.handle(WebEvent(this, WebEvent.RESIZED, Rectangle2D.EMPTY))
    }

    @Test
    fun onVisibilityChanged() {
        engine.callOnVisibilityChanged {
            assertEquals(this, it.source)
            assertEquals(WebEvent.VISIBILITY_CHANGED, it.eventType)
            assertFalse(it.data)
        }
        engine.onVisibilityChanged.handle(WebEvent(this, WebEvent.VISIBILITY_CHANGED, false))
    }

    @Test
    fun onError() {
        engine.callOnError {
            assertEquals(this, it.source)
            assertEquals(WebErrorEvent.USER_DATA_DIRECTORY_IO_ERROR, it.eventType)
            assertEquals("Hello world", it.message)
        }
        engine.onError.handle(
            WebErrorEvent(
                this,
                WebErrorEvent.USER_DATA_DIRECTORY_IO_ERROR,
                "Hello world",
                IOException()
            )
        )
    }
}