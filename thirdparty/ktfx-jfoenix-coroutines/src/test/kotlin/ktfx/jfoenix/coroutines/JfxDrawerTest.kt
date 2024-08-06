package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.initToolkit
import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxDrawerTest {
    private lateinit var drawer: JFXDrawer

    @BeforeTest
    fun start() {
        initToolkit()
        drawer = JFXDrawer()
    }

    @Test
    fun onDrawerClosed() {
        drawer.onDrawerClosed(Dispatchers.Unconfined) {
            assertEquals(JFXDrawerEvent.CLOSED, it.eventType)
        }
        drawer.onDrawerClosed.handle(JFXDrawerEvent(JFXDrawerEvent.CLOSED))
    }

    @Test
    fun onDrawerClosing() {
        drawer.onDrawerClosing(Dispatchers.Unconfined) {
            assertEquals(JFXDrawerEvent.CLOSING, it.eventType)
        }
        drawer.onDrawerClosing.handle(JFXDrawerEvent(JFXDrawerEvent.CLOSING))
    }

    @Test
    fun onDrawerOpened() {
        drawer.onDrawerOpened(Dispatchers.Unconfined) {
            assertEquals(JFXDrawerEvent.OPENED, it.eventType)
        }
        drawer.onDrawerOpened.handle(JFXDrawerEvent(JFXDrawerEvent.OPENED))
    }

    @Test
    fun onDrawerOpening() {
        drawer.onDrawerOpening(Dispatchers.Unconfined) {
            assertEquals(JFXDrawerEvent.OPENING, it.eventType)
        }
        drawer.onDrawerOpening.handle(JFXDrawerEvent(JFXDrawerEvent.OPENING))
    }
}
