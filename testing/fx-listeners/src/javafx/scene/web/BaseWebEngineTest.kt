package javafx.scene.web

import com.sun.javafx.application.PlatformImpl
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseWebEngineTest {

    abstract fun WebEngine.callOnAlert(action: (WebEvent<String>) -> Unit)

    private lateinit var engine: WebEngine

    @BeforeTest fun start() {
        PlatformImpl.startup { }
        engine = WebEngine()
    }

    @Test fun onAlert() {
        engine.callOnAlert {
            assertEquals(this, it.source)
            assertEquals(WebEvent.ALERT, it.eventType)
            assertEquals("", it.data)
        }
        engine.onAlert.handle(WebEvent(this, WebEvent.ALERT, ""))
    }
}