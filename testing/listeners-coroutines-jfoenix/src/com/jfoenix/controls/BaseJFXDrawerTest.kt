package ktfx.jfoenix.test

import com.hendraanggrian.ktfx.test.initToolkit
import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseJFXDrawerTest {
    private lateinit var drawer: JFXDrawer

    abstract fun JFXDrawer.callOnDrawerClosed(action: (JFXDrawerEvent) -> Unit)
    abstract fun JFXDrawer.callOnDrawerClosing(action: (JFXDrawerEvent) -> Unit)
    abstract fun JFXDrawer.callOnDrawerOpened(action: (JFXDrawerEvent) -> Unit)
    abstract fun JFXDrawer.callOnDrawerOpening(action: (JFXDrawerEvent) -> Unit)

    @BeforeTest
    fun start() {
        initToolkit()
        drawer = JFXDrawer()
    }

    @Test
    fun onDrawerClosed() {
        drawer.callOnDrawerClosed { assertEquals(JFXDrawerEvent.CLOSED, it.eventType) }
        drawer.onDrawerClosed.handle(JFXDrawerEvent(JFXDrawerEvent.CLOSED))
    }

    @Test
    fun onDrawerClosing() {
        drawer.callOnDrawerClosing { assertEquals(JFXDrawerEvent.CLOSING, it.eventType) }
        drawer.onDrawerClosing.handle(JFXDrawerEvent(JFXDrawerEvent.CLOSING))
    }

    @Test
    fun onDrawerOpened() {
        drawer.callOnDrawerOpened { assertEquals(JFXDrawerEvent.OPENED, it.eventType) }
        drawer.onDrawerOpened.handle(JFXDrawerEvent(JFXDrawerEvent.OPENED))
    }

    @Test
    fun onDrawerOpening() {
        drawer.callOnDrawerOpening { assertEquals(JFXDrawerEvent.OPENING, it.eventType) }
        drawer.onDrawerOpening.handle(JFXDrawerEvent(JFXDrawerEvent.OPENING))
    }
}
