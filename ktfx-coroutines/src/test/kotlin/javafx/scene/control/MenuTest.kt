package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.Event
import javafx.scene.control.Menu
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuTest : ApplicationTest() {
    private lateinit var menu: Menu

    override fun start(stage: Stage) {
        stage.testScene<Menu>()
        menu = Menu()
    }

    @Test
    fun onShowing() {
        interact {
            menu.onShowing {
                assertEquals(this@MenuTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            menu.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onShown() {
        interact {
            menu.onShown {
                assertEquals(this@MenuTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            menu.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHiding() {
        interact {
            menu.onHiding {
                assertEquals(this@MenuTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            menu.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHidden() {
        interact {
            menu.onHidden {
                assertEquals(this@MenuTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            menu.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
