package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.testScene
import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxDrawerTest : ApplicationTest() {
    private lateinit var drawer: JFXDrawer

    override fun start(stage: Stage) {
        stage.testScene<JFXDrawer>()
        drawer = JFXDrawer()
    }

    @Test
    fun onDrawerClosed() {
        interact {
            drawer.onDrawerClosed {
                assertEquals(JFXDrawerEvent.CLOSED, it.eventType)
            }
            drawer.onDrawerClosed.handle(JFXDrawerEvent(JFXDrawerEvent.CLOSED))
        }
    }

    @Test
    fun onDrawerClosing() {
        interact {
            drawer.onDrawerClosing {
                assertEquals(JFXDrawerEvent.CLOSING, it.eventType)
            }
            drawer.onDrawerClosing.handle(JFXDrawerEvent(JFXDrawerEvent.CLOSING))
        }
    }

    @Test
    fun onDrawerOpened() {
        interact {
            drawer.onDrawerOpened {
                assertEquals(JFXDrawerEvent.OPENED, it.eventType)
            }
            drawer.onDrawerOpened.handle(JFXDrawerEvent(JFXDrawerEvent.OPENED))
        }
    }

    @Test
    fun onDrawerOpening() {
        interact {
            drawer.onDrawerOpening {
                assertEquals(JFXDrawerEvent.OPENING, it.eventType)
            }
            drawer.onDrawerOpening.handle(JFXDrawerEvent(JFXDrawerEvent.OPENING))
        }
    }
}
