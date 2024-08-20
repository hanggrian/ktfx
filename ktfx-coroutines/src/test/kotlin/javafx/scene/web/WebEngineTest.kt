package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import java.io.IOException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class WebEngineTest : ApplicationTest() {
    private lateinit var engine: WebEngine

    override fun start(stage: Stage) {
        stage.testScene<WebEngine>()
        engine = WebEngine()
    }

    @Test
    fun onAlert() {
        interact {
            engine.onAlert {
                assertEquals(this@WebEngineTest, it.source)
                assertEquals(WebEvent.ALERT, it.eventType)
                assertEquals("Hello world", it.data)
            }
            engine.onAlert.handle(WebEvent(this, WebEvent.ALERT, "Hello world"))
        }
    }

    @Test
    fun onStatusChanged() {
        interact {
            engine.onStatusChanged {
                assertEquals(this@WebEngineTest, it.source)
                assertEquals(WebEvent.STATUS_CHANGED, it.eventType)
                assertEquals("Hello world", it.data)
            }
            engine.onStatusChanged.handle(WebEvent(this, WebEvent.STATUS_CHANGED, "Hello world"))
        }
    }

    @Test
    fun onResized() {
        interact {
            engine.onResized {
                assertEquals(this@WebEngineTest, it.source)
                assertEquals(WebEvent.RESIZED, it.eventType)
                assertEquals(Rectangle2D.EMPTY, it.data)
            }
            engine.onResized.handle(WebEvent(this, WebEvent.RESIZED, Rectangle2D.EMPTY))
        }
    }

    @Test
    fun onVisibilityChanged() {
        interact {
            engine.onVisibilityChanged {
                assertEquals(this@WebEngineTest, it.source)
                assertEquals(WebEvent.VISIBILITY_CHANGED, it.eventType)
                assertFalse(it.data)
            }
            engine.onVisibilityChanged.handle(WebEvent(this, WebEvent.VISIBILITY_CHANGED, false))
        }
    }

    @Test
    fun onError() {
        interact {
            engine.onError {
                assertEquals(this@WebEngineTest, it.source)
                assertEquals(WebErrorEvent.USER_DATA_DIRECTORY_IO_ERROR, it.eventType)
                assertEquals("Hello world", it.message)
            }
            engine.onError.handle(
                WebErrorEvent(
                    this,
                    WebErrorEvent.USER_DATA_DIRECTORY_IO_ERROR,
                    "Hello world",
                    IOException(),
                ),
            )
        }
    }
}
